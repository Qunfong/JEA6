package REST;

import Domain.User;
import JSONObjects.RelationJSON;
import JSONObjects.UserJSON;
import Service.UserService;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by Joris on 9-3-2017.
 */
@Path("user")
public class UserREST {

    UserService userService;

    public UserREST() {
        userService = new UserService();
    }

    @POST
    @Consumes("application/json")
    @Path("create")
    public void create(final UserJSON input) {
        userService.createUser(new User(input.id, input.photo, input.username, input.bio, input.web, input.location, input.password));
    }

    @PUT
    @Consumes("application/json")
    @Path("update")
    public void update(final UserJSON input) {
        userService.updateUser(new User(input.id, input.photo, input.username, input.bio, input.web, input.location, input.password));
    }

    @GET
    @Produces("application/json")
    @Path("user")
    public User getUserByName(@QueryParam("name") String username, @QueryParam("id") int id) {
        if (username == null)
            return userService.getUser(id);
        return userService.getUser(username);
    }

    @POST
    @Consumes("application/json")
    @Path("follow")
    public void follow(final RelationJSON input) throws Exception {
        userService.follow(input.followerId, input.followingId);
    }

    @GET
    @Produces("application/json")
    @Path("getfollowers")
    public List<User> getFollowers(@QueryParam("user") int userId) throws Exception{
        return userService.getFollowers(userId);
    }

    @GET
    @Produces("application/json")
    @Path("getfollowing")
    public List<User> getFollowing(@QueryParam("user") int userId) throws Exception{
        return userService.getFollowing(userId);
    }
}
