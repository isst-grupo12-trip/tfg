package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;

import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.crypto.hash.Sha256Hash;

import es.upm.dit.isst.webLab.dao.TFGDAO;
import es.upm.dit.isst.webLab.dao.TFGDAOImplementation;
import es.upm.dit.isst.webLab.model.Professor;
import es.upm.dit.isst.webLab.model.TFG;


@WebServlet("/CreateTFGServlet")
public class CreateTFGServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter( "name" );
		String password = req.getParameter( "password" );
		String email = req.getParameter( "email" );
		String title = req.getParameter( "title" );
		int status = req.getParameter( "status" );
		byte[] document = req.getParameter( "document" );
		double grade = req.getParameter( "grade" );
		Professor advisor = req.getParameter( "advisor" );

		TFG tfg = new TFG();
		tfg.setName( name );
		tfg.setEmail( email );
		tfg.setTitle( title );
		
		professor.setPassword( new Sha256Hash( password ).toString() );
		
		TFGDAO pdao = TFGDAOImplementation.getInstance();
		pdao.create( professor );
		
		resp.sendRedirect( req.getContextPath() + "/AdminServlet" );
	}
}
