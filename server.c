#include <stdio.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <netinet/in.h>
#include <netdb.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <arpa/inet.h> 
#include <time.h> 

#define PORT 5555

int main(int argc, char *argv[])
{
    int listenfd = 0, connfd = 0;
    struct sockaddr_in serv_addr; 

    char sendBuff[500];
    
    listenfd = socket(AF_INET, SOCK_STREAM, 0);
    memset(&serv_addr, '0', sizeof(serv_addr)); 
    memset(sendBuff, '0', sizeof(sendBuff)); 

    serv_addr.sin_family = AF_INET;
    serv_addr.sin_addr.s_addr = htonl(INADDR_ANY);
    serv_addr.sin_port = htons(PORT); 

    bind(listenfd, (struct sockaddr*)&serv_addr, sizeof(serv_addr)); 

    listen(listenfd, 5); 
    printf("\nServer listening for connections!\n");
    
    time_t t_seconds;
	int readbytes = 0;
	
    while(1)
    {char recvBuff[500];
        connfd = accept(listenfd, (struct sockaddr*)NULL, NULL); 
       // printf("\nAccepted a connection\n");
        //t_seconds = time(0);
	if(recv(connfd,recvBuff,sizeof(recvBuff),0)<0)
{
	printf("ERROR\n");
}	
printf("%s\n",recvBuff);
int len;
len=strlen(recvBuff);
int i,j=0;
for(i=len-1;i>=0;i--)
{
	sendBuff[j++]=recvBuff[i];
	}
sendBuff[j]='\0';
//snprintf(sendBuff,sizeof(sendBuff),"%s\n",ctime(&t_seconds));
//write(connfd,sendBuff,strlen(sendBuff));
send(connfd,sendBuff,sizeof(sendBuff),0);
        close(connfd);
        
     }


}
