package app.ledger.demo.controller;


import app.ledger.demo.model.AppText;
import app.ledger.demo.model.AppUser;
import app.ledger.demo.services.AdminService;
import app.ledger.demo.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;



@RequestMapping("/api/user/")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    public static final String HELLO_TEXT = "Hello from Spring Boot Backend!";

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    /**
     * Print message
     * @return hello message
     */
    @RequestMapping(path = "/hello")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public String sayHello() {
        LOG.info("GET called on /hello resource");
        return HELLO_TEXT;
    }

    /**
     * Get user by using username
     * @param username
     * @return user
     */
    @GetMapping(path = "{username}")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public ResponseEntity getUserByUsername(@PathVariable("username") String username) {
        AppUser user = adminService.getUser(username);
        if (user != null)
            return ResponseEntity.status(HttpStatus.FOUND).body(user);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new AppText("User does not exist, try again."));
    }
//    /**
//     * Update user's task
//     * @param tid
//     * @param title
//     * @param description
//     * @param dateStart
//     * @param dateEnd
//     * @return Update task
//     */
//    @PostMapping(path = "edit/{tid}/{title}/{description}/{dateStart}/{dateEnd}")
//    public ResponseEntity updateTask(@PathVariable("tid") String tid,
//                                     @PathVariable("title") String title, @PathVariable("description") String description,
//                                     @PathVariable("dateStart") String dateStart, @PathVariable("dateEnd") String dateEnd
//                                     ) {
//        AppTask newTask = new AppTask(title, description, dateStart, dateEnd);
//        if (userService.updateTask(newTask, Long.parseLong(tid)))
//            return ResponseEntity.status(HttpStatus.CREATED).body(new AppText("Updated task info successfully!"));
//        else{
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AppText("Update rejected! Invalid date."));
//        }
//    }
//
//    /**
//     * Remove user's task
//     * @param tid
//     * @return Message to tell user that we successfully remove task
//     */
//    @PostMapping(path = "remove/{tid}")
//    public ResponseEntity removeTask(@PathVariable("tid") String tid) {
//        AppTask task = new AppTask();
//        task.setTid(Long.parseLong(tid));
//        userService.removeTask(task);
//        return ResponseEntity.status(HttpStatus.FOUND).body(new AppText("Removed task successfully"));
//    }

    /**
     * Update user information
     * @param username
     * @param newusername
     * @return Message to user
     */
    @PostMapping(path = "update/{username}/{newusername}/{name}/{surname}")
    public ResponseEntity editUser(@PathVariable("username") String username,
                                   @PathVariable("newusername") String newusername){
        AppUser newInfo = adminService.getUser(username);
        newInfo.setUsername(newusername);
        if(adminService.updateUserInfo(username, newInfo)) return ResponseEntity.status(HttpStatus.OK).body(new AppText("Updated user info successfully"));
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AppText("Update rejected! Invalid new username."));
        }
    }


}
