import java.io.*;
import java.net.Socket;

public class SendMessage extends AsyncTask<String, Void, Void> 
{
	private Exception exception;
	@Override
	String ip;
	int po;
	SendMessage(String ip,int po)
	{
		this.ip=ip;
		thispo=po;
	}
	protected Void doInBackground(String... params)
	{
		try
		{
			try
			{
				Socket socket=new Socket("192.168.60.146",8888);
				PrintWriter outToServer=new PrintWriter(
					new OutputStreamWriter(
						socket.getOutputStream()));
				outToServer.print(params[0]);
				outToServer.flush();

			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		catch(Exception e)
		{
			this.exception=e;
			return null;
		}
		return null;
	}
}