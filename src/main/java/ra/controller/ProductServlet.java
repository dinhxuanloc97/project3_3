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
import ra.model.util.ConnectionDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "ProductServlet", value = "/ProductServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 10)
public class ProductServlet extends HttpServlet {
    private ProductSevice<Product, String> productService = new ProductServiceImp();
    private CatalogService<Catalog,Integer> catalogService = new CatalogServiceImp();
    private UserServices<User,String> userService = new UserSevicesImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action != null && action.equals("GetAll")) {
            getAllProduct(request, response);
        } else if (action.equals("NewProduct")) {
            List<Catalog> listCatalog = catalogService.findAll();
            request.setAttribute("listCat", listCatalog);
            request.getRequestDispatcher("views/admin/newProduct.jsp").forward(request, response);
        } else if (action.equals("Delete")) {
            String productId = request.getParameter("productId");
            boolean result = productService.delete(productId);
            if (result) {
                getAllProduct(request, response);
            }
        } else if (action.equals("GetDetail")) {
            //Lay thong tin chi tiet cua san pham theo id
            String productId = (request.getParameter("productId"));
            Product pro = productService.findById(productId);
            request.setAttribute("pro", pro);
            request.getRequestDispatcher("views/admin/productDetail.jsp").forward(request, response);
        }else if (action.equals("Update")) {
            //Thuc hien lay thong tin sinh vien theo studentId
            String productId = (request.getParameter("productId"));
            Product productUpdate = productService.findById(productId);
            //Chuyen du lieu sang trang updateStudent.jsp
            List<Catalog> listCatalog = catalogService.findAll();
            request.setAttribute("listCat", listCatalog);
            request.setAttribute("productUpdate", productUpdate);
            request.getRequestDispatcher("views/admin/updateProduct.jsp").forward(request, response);
        }
    }
    public void getAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> listPro = productService.findAll();
        request.setAttribute("listPro", listPro);
        request.getRequestDispatcher("views/admin/product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        //Lay du lieu anh tu request day vao db va folder
        //db: chua link den anh
        //folder: chua anh upload
        //B1: Tao thu muc chua anh upload
        if (action.equals("Create")) {
            String pathFolderImage = "/Users/dinhxuanloc/Desktop/Project3/project/src/main/webapp/views/images";
            File file = new File(pathFolderImage);
            if (!file.exists()) {
                file.mkdir();
            }
            Product proNew = new Product();
            proNew.setProductId(request.getParameter("productId"));
            proNew.setProductName(request.getParameter("productName"));
            proNew.setPrice(Float.parseFloat(request.getParameter("price")));
            proNew.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            proNew.setDiscription(request.getParameter("description"));
            proNew.setCatalogId(Integer.parseInt(request.getParameter("catalogId")));
            proNew.setProductStatus(Boolean.parseBoolean(request.getParameter("status")));
            //B2. Lay du lieu anh tu request, add duong dan vao doi tuong proNew, ghi anh vao folder images
            Part part = request.getPart("image");
            proNew.setProductImage(part.getSubmittedFileName());
            part.write(pathFolderImage + File.separator + part.getSubmittedFileName());
            boolean result = productService.save(proNew);
            if (result) {
                getAllProduct(request, response);
            }
        } else if (action.equals("Search")) {
            String prName = request.getParameter("searchName");
            request.setAttribute("listPro", productService.searchByName(prName));
            request.getRequestDispatcher("views/admin/product.jsp").forward(request, response);
        } else if (action.equals("Update")) {
            String pathFolderImage = "/Users/dinhxuanloc/Desktop/Project3/project/src/main/webapp/views/images";
            File file = new File(pathFolderImage);
            if (!file.exists()) {
                file.mkdir();
            }
            Product pro = new Product();
            pro.setProductId(request.getParameter("productId"));
            pro.setProductName(request.getParameter("productName"));
            pro.setPrice(Float.parseFloat(request.getParameter("price")));
            pro.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            pro.setDiscription(request.getParameter("description"));
            pro.setCatalogId(Integer.parseInt(request.getParameter("catalogId")));
            pro.setProductStatus(Boolean.parseBoolean(request.getParameter("status")));
            Part part = request.getPart("image");
            if (part.getSubmittedFileName()!="") {
                pro.setProductImage(part.getSubmittedFileName());
                part.write(pathFolderImage + File.separator + part.getSubmittedFileName());
            }else{
                pro.setProductImage(request.getParameter("oldImage"));
            }
            boolean result = productService.update(pro);
            if (result) {
                getAllProduct(request, response);
            }
        }
    }
}
