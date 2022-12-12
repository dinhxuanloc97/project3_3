package ra.controller;

import ra.model.entity.Catalog;
import ra.model.entity.Product;
import ra.model.entity.User;
import ra.model.service.CatalogService;
import ra.model.service.ProductSevice;
import ra.model.service.UserServices;
import ra.model.serviceImp.CatalogServiceImp;
import ra.model.serviceImp.ProductServiceImp;
import ra.model.serviceImp.UserSevicesImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/HomeServlet")
public class HomeServlet extends HttpServlet {
    private static ProductSevice<Product,String> productSeviceImp = new ProductServiceImp();
    private UserServices<User,String> userService = new UserSevicesImp();
    private CatalogService<Catalog,Integer> catalogService = new CatalogServiceImp();
    private ProductSevice<Product, String> productService = new ProductServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("Home")) {
            List<Product> listPro = productSeviceImp.getSpecialProduct();
            request.setAttribute("listPro", listPro);
            request.getRequestDispatcher("views/user/index.jsp").forward(request, response);
        }else if (action.equals("proDetail")) {
            //Lay thong tin chi tiet cua san pham theo id
            String productId = (request.getParameter("productId"));
            Product pro = productService.findById(productId);
            request.setAttribute("pro", pro);
            request.getRequestDispatcher("views/user/product.jsp").forward(request, response);
        } else if (action.equals("Shop")){
            request.setAttribute("listCat",catalogService.findAll());
            request.setAttribute("listPro",productService.findAll());
            request.getRequestDispatcher("views/user/shop.jsp").forward(request, response);
        } else if (action.equals("getProductByCatalog")) {
            String catId = request.getParameter("catId");
            List<Product> listPro = productService.getProductlogId(catId);
            request.setAttribute("listPro",listPro);
            request.setAttribute("listCat",catalogService.findAll());
            request.setAttribute("catId",catId);
            request.getRequestDispatcher("views/user/shop.jsp").forward(request,response);
        } else if (action.equals("Search")) {
            String name = request.getParameter("Searchname");
            List<Product> productList = productService.searchByName(name);
            request.setAttribute("listPro",productList);
            request.getRequestDispatcher("views/user/shop.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
