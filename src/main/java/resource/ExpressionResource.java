package resource;


import dao.ExpressionDao;
import model.Expression;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/expression")
public class ExpressionResource implements MainResource<Expression> {
    private final ExpressionDao expressionDao = new ExpressionDao();

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response get(@PathParam("id") int id) {
        Expression expression = expressionDao.get(id);
        if (expression!=null) {
            return Response.ok(expression, MediaType.APPLICATION_JSON_TYPE).build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Expression> list() {
        return expressionDao.fetch();
    }
}
