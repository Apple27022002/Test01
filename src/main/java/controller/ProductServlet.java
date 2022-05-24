package controller;

import model.Product;
import service.ProductServiceIPM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    ProductServiceIPM productService =new ProductServiceIPM();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if (action==null){
            action ="";
        }switch (action){
            case"create":
                creatProduct(request,response);
                break;
            case "edit":
                editProduct(request,response);
                break;
            default:
                showListPage(request, response);

        }

    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        int price=Integer.parseInt(request.getParameter("price"));
        String name=request.getParameter("name");
        productService.update(id,new Product(id,name,price));
        response.sendRedirect("products");
    }

    private void creatProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int price = Integer.parseInt(request.getParameter("price"));
        String name = request.getParameter("name");
        productService.save(new Product(id,name,price));
        response.sendRedirect("products");

    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if (action==null){
            action ="";
        }switch (action){
            case"create":
                showCreateForm(request,response);
                break;
            case"edit":
                showEditForm(request,response);
                break;
            default:
                showListPage(request, response);
                
        }

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("edit.jsp");
        int id =Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("spCanSua",product);
        requestDispatcher.forward(request,response);
    }



    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("create.jsp");

        requestDispatcher.forward(request,response);
    }


    private void showListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("list.jsp");
        List<Product>products=productService.findAll();
        request.setAttribute("danhSach" ,products);
        requestDispatcher.forward(request,response);
    }
}
