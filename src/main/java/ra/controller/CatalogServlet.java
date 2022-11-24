package ra.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ra.model.entity.Catalog;
import ra.model.service.CatalogService;
import ra.model.serviceImp.CatalogServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@WebServlet(name = "CatalogServlet", value = "/CatalogServlet")
public class CatalogServlet extends HttpServlet {
    private static CatalogService<Catalog,Integer> catalogService = new CatalogServiceImp();
    private static final Gson GSON = new GsonBuilder().create();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("GetAll")){
            getAllCatalog(request,response);
        } else if (action.equals("GetById")) {
            int catalogId = Integer.parseInt(request.getParameter("catalogId"));
            Catalog catUpdate = catalogService.findById(catalogId);
            //Chuyen du lieu tu java object sang JSON
            String json = GSON.toJson(catUpdate);
            response.setStatus(200);
            response.setHeader("Content-Type","application/json");
            Writer out = response.getWriter();
            out.write(json);
            out.flush();
        }
    }

    public void getAllCatalog(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        List<Catalog> listCat = catalogService.findAll();
        request.setAttribute("listCat",listCat);
        request.getRequestDispatcher("views/admin/catalogs.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("Create")) {
            Catalog catalog = new Catalog();
            catalog.setCatalogName(request.getParameter("catalogName"));
            catalog.setCatalogStatus(Boolean.parseBoolean(request.getParameter("status")));
            boolean result = catalogService.save(catalog);
            if (result) {
                getAllCatalog(request, response);
            }
        }else if (action.equals("Delete")) {
            int catalogId = Integer.parseInt(request.getParameter("catDeleteId"));
            boolean result = catalogService.delete(catalogId);
            if (result) {
                getAllCatalog(request, response);
            }
        }else if (action.equals("Update")) {
            Catalog cat = new Catalog();
            cat.setCatalogId(Integer.parseInt(request.getParameter("catalogId")));
            cat.setCatalogName(request.getParameter("catalogName"));
            cat.setCatalogStatus(Boolean.parseBoolean(request.getParameter("status")));
            boolean result = catalogService.update(cat);
            if (result){
                getAllCatalog(request,response);
            }
        }else if (action.equals("Search")) {
            String prName = request.getParameter("searchName");
            request.setAttribute("listCat", catalogService.searchByName(prName));
            request.getRequestDispatcher("views/admin/catalogs.jsp").forward(request, response);
        }
    }
}
