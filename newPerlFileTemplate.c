#include "mpi.h"
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/*ukuran matrix N x N*/
#define  N 4 
#define MASTER 0               /* taskid of first task */
#define FROM_MASTER 1          /* setting a message type */
#define FROM_WORKER 2          /* setting a message type */

/*Variabel yang akan digunakan untuk menyimpan nilai matrik soal dan jawaban */
int A[N][N], B[N][N], C[N][N];

void readFile();
void printMatrix(int matrix[N][N]);
void writeMatrixOnFile(int matrix[N][N], char* file);
void printFinalResult();

/*Untuk membuka file ketika majikan memulai tasknya*/
void readFile(){
	int i, j;
	FILE *f1, *f2;	

	f1 = fopen("Matrix_4A.txt", "r");
	f2 = fopen("Matrix_4B.txt", "r");

	if(f1 == NULL) {
		printf("File 1 tidak bisa dibuka!\n");
	}
	for(i=0; i<N; i++)
		for(j=0; j<N; j++)
			fscanf(f1, "%d", &A[i][j]);

	if(f2 == NULL) {
		printf("File 2 tidak bisa dibuka!\n");
	}
	for(i=0; i<N; i++)
		for(j=0; j<N; j++)
			fscanf(f2, "%d", &B[i][j]);

	fclose(f1);
	fclose(f2);
}

int main(int argc,char *argv[]) {
	

int name_len;
char processor_name[MPI_MAX_PROCESSOR_NAME];
int	numtasks,              /* number of tasks in partition */
	taskid,                /* a task identifier */
	numworkers,            /* number of worker tasks */
	source,                /* task id of message source */
	dest,                  /* task id of message destination */
	mtype,                 /* message type */
	rows,                  /* rows of matrix A sent to each worker */
	averow, extra, offset, /* used to determine rows sent to each worker */
	i, j, k, rc;           /* misc */
  	MPI_Status status;
// double	a[N][N],           /* matrix A to be multiplied */
// 	b[N][N],           /* matrix B to be multiplied */
// 	c[N][N];           /* result matrix C */
	MPI_Init(&argc,&argv);
	MPI_Comm_rank(MPI_COMM_WORLD,&taskid);
	MPI_Comm_size(MPI_COMM_WORLD,&numtasks);


if (numtasks < 1 ) {
	  printf("Need at least one MPI tasks. Quitting...\n");
	  MPI_Abort(MPI_COMM_WORLD, rc);
	  exit(1);
  }
  	int start=0,end=0,total=0;

	srand(time(NULL));
numworkers = numtasks-1;

/**************************** master task ************************************/
   if (taskid == MASTER)
   {

	readFile();

	srand(time(NULL));
	start = MPI_Wtime();	
      printf("mpi_mm has started with %d tasks.\n",numtasks);
      printf("Initializing arrays...\n");

      if (numworkers==0){
      	for (k=0; k<N; k++)
         for (i=0; i<N; i++)
         {
            C[i][k] = 0.0;
            for (j=0; j<N; j++)
               C[i][k] = C[i][k] + A[i][j] * B[j][k];
         }
     }else{
	      /* Send matrix data to the worker tasks */
	      averow = N/numworkers;
	      extra = N%numworkers;
	      offset = 0;
	      mtype = FROM_MASTER;
	      for (dest=1; dest<=numworkers; dest++)
	      {
	         rows = (dest <= extra) ? averow+1 : averow;   	
	         MPI_Send(&offset, 1, MPI_INT, dest, mtype, MPI_COMM_WORLD);
	         MPI_Send(&rows, 1, MPI_INT, dest, mtype, MPI_COMM_WORLD);
	         MPI_Send(&A[offset][0], rows*N, MPI_DOUBLE, dest, mtype,
	                   MPI_COMM_WORLD);
	         MPI_Send(&B, N*N, MPI_DOUBLE, dest, mtype, MPI_COMM_WORLD);
	         offset = offset + rows;
	      }

	      /* Receive results from worker tasks */
	      mtype = FROM_WORKER;
	      for (i=1; i<=numworkers; i++)
	      {
	         source = i;
	         MPI_Recv(processor_name,name_len,MPI_CHAR,source,mtype,MPI_COMM_WORLD,&status);
	         MPI_Recv(&offset, 1, MPI_INT, source, mtype, MPI_COMM_WORLD, &status);
	         MPI_Recv(&rows, 1, MPI_INT, source, mtype, MPI_COMM_WORLD, &status);
	         MPI_Recv(&C[offset][0], rows*N, MPI_DOUBLE, source, mtype, 
	                  MPI_COMM_WORLD, &status);
	       }

  		}

		end = MPI_Wtime();
      /* Print results */
      
      printFinalResult();

		printf("\n");
		printf("Execution time : %.8f\n\n", end-start);
   }


/**************************** worker task ************************************/
   if (taskid > MASTER)
   {
      mtype = FROM_MASTER;
      MPI_Recv(&offset, 1, MPI_INT, MASTER, mtype, MPI_COMM_WORLD, &status);
      MPI_Recv(&rows, 1, MPI_INT, MASTER, mtype, MPI_COMM_WORLD, &status);
      MPI_Recv(&A, rows*N, MPI_DOUBLE, MASTER, mtype, MPI_COMM_WORLD, &status);
      MPI_Recv(&B, N*N, MPI_DOUBLE, MASTER, mtype, MPI_COMM_WORLD, &status);

      for (k=0; k<N; k++)
         for (i=0; i<rows; i++)
         {
            C[i][k] = 0.0;
            for (j=0; j<N; j++)
               C[i][k] = C[i][k] + A[i][j] * B[j][k];
         }
      mtype = FROM_WORKER;
      MPI_Get_processor_name(processor_name,&name_len);
      MPI_Send(processor_name,name_len,MPI_CHAR,MASTER,mtype,MPI_COMM_WORLD);
      MPI_Send(&offset, 1, MPI_INT, MASTER, mtype, MPI_COMM_WORLD);
      MPI_Send(&rows, 1, MPI_INT, MASTER, mtype, MPI_COMM_WORLD);
      MPI_Send(&C, rows*N, MPI_DOUBLE, MASTER, mtype, MPI_COMM_WORLD);
   }
   MPI_Finalize();

	// MPI_Barrier(MPI_COMM_WORLD);
	// 
	
	// MPI_Bcast(B, N*N, MPI_INT, 0, MPI_COMM_WORLD);
	// MPI_Scatter (A, N*N/numtasks, MPI_INT, A[from], N*N/numtasks, MPI_INT, 0, MPI_COMM_WORLD);

	// for(i=from; i<to; i++)
	// 	for(j=0; j<N; j++) {
	// 		C[i][j]=0;
	// 		for(k=0; k<N; k++)
	// 			C[i][j] += A[i][k] * B[k][j];
	// 	}

	// MPI_Gather(C[from], N*N/numtasks, MPI_INT, C, N*N/numtasks, MPI_INT, 0, MPI_COMM_WORLD);

	// MPI_Barrier(MPI_COMM_WORLD);
	// end = MPI_Wtime();


	// if(rank==0) {
	// 	
	// 	printf("\n\nExecution time : %.8f\n\n", end-start);
	// }
	// MPI_Finalize();
	return 0;
}


/*Mencetak matrix yang telah disimpan divariabel ke layar*/
void printMatrix(int matrix[N][N]) {
	int i,j =0;

	/*Membaca tiap nilai array*/
	for(i=0; i<N; i++) {
		printf("\n\n");
		for(j=0; j<N; j++)
			printf("%2d\t", matrix[i][j]);
	}
}


/*Mencetak tampilan akhir dari perkalian dua buah matrix*/
void printFinalResult(){
	printf("\n");
	printMatrix(A);
	printf("\n\n\t      * \n");
	printMatrix(B);
	printf("\n\n\t      = \n");
	printMatrix(C);

	writeMatrixOnFile(C, "MatrixHasil.txt");
	printf("\n");
}

/*Digunakan untuk menulis matrik hasil perkalian ke file*/
void writeMatrixOnFile(int matrix[N][N], char* file) {
	int i,j;

	/*Membuka file dengan pointer to file*/
	FILE *f = fopen(file, "w");
	if(f == NULL) {
		printf("File tidak bisa dibuka!\n");
		exit(1);
	}

	/*Melakukan penulisan pada file perbaris */
	for(i=0; i<N; i++) {
		for(j=0; j<N; j++) {
			fprintf(f, "%2d", matrix[i][j]);
		}
		fprintf(f, "\n");
	}

	/*Menutup file*/
	fclose(f);
}



