package resource;

import dao.CategoryDao;
import model.Category;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/category")
public class CategoryResource implements MainResource<Category> {
    private final CategoryDao categoryDao = new CategoryDao();

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response get(@PathParam("id") int id) {
        Category category = categoryDao.get(id);
        if (category!=null) {
            return Response.ok(category, MediaType.APPLICATION_JSON_TYPE).build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Category> list() {
        return categoryDao.fetch();
    }
}
