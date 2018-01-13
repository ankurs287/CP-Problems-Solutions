import socket
import sys

def Tcp_Read( ):
	a = ' '
	b = ''
	while a != '\r':
		a = s.recv(1)
		b = b + a
	return b


HOST = '' #this is your localhost
PORT = 12345



global s 
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
#socket.socket: must use to create a socket.
#socket.AF_INET: Address Format, Internet = IP Addresses.
#socket.SOCK_STREAM: two-way, connection-based byte streams.
print 'socket created'
 
#Bind socket to Host and Port
try:
    s.bind((HOST, PORT))
except socket.error as err:
    print 'Bind Failed, Error Code: ' + str(err[0]) + ', Message: ' + err[1]
    sys.exit()
 
print 'Socket Bind Success!'
 
 
#listen(): This method sets up and start TCP listener.
s.listen(10)
print 'Socket is now listening'
 
while 1:
    # conn, addr = s.accept()
    # print 'Connect with ' + addr[0] + ':' + str(addr[1])
    s2 = s.accept()[0]
    buf = s.recv(64)
    print buf
    s.send("fromsrvr" + '\r')
s.close()
 