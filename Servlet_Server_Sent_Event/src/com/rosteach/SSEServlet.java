package com.rosteach;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SSEServlet")
public class SSEServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    public SSEServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		response.setContentType("text/event-stream");
		response.setCharacterEncoding("UTF-8");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw = null;
		while(true){
			try{
				double rN = Math.random()*10000;
				pw = response.getWriter();
				pw.print("data:"+"[next server time check event in "+Math.round(rN/1000)+" seconds]\n");
				pw.print("data:"+"Time: "+Calendar.getInstance().getTime()+"\n\n");
				response.flushBuffer();
				Thread.sleep((long) rN);
			}catch(IOException | InterruptedException e){
				pw.close();
				break;
			}
		}
	}

}
