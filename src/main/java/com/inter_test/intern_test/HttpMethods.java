package com.inter_test.intern_test;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
public class HttpMethods
{
    private StoreData storeData = new StoreData();

    // The GET method is used to retrieve information from the given server using a given URI. Requests using GET should only retrieve data and should have no other effect on the data.
    @GetMapping("/getData")
    public ResponseEntity<Set<Data>> get()
    {
        return ResponseEntity.ok().body(storeData.all());
    }

    // A POST request is used to send data to the server, for example, customer information, file upload, etc. using HTML forms.
    @PostMapping(path = "/createData", consumes = "application/x-www-form-urlencoded", produces = "application/json")
    public ResponseEntity<Set<Data>> post(@RequestParam(value = "info", defaultValue = "Hello World!") String info,
                                          @RequestParam(value = "email", defaultValue = "test@test.ie") String email)
    {
        storeData.addNonConstructorData(info, email);
        return ResponseEntity.ok().body(storeData.all());
    }


    // Removes all current representations of the target resource given by a URI. In this case, the target is id
    @DeleteMapping(value = "/deleteData/{id}")
    public String delete(@PathVariable int id)
    {
        boolean isRemoved = storeData.delete(id);
        if (!(isRemoved))
            return "The deletion of the specified ID was unsuccessful";
        return "The deletion of the specified ID was successful";
    }

    // PUT
    // Replaces all current representations of the target resource with the uploaded content.
    @PutMapping(value = "/updateAllData/{id}")
    public String put(@PathVariable int id, @RequestParam(value = "info", defaultValue = "Hello World!, my name is Ethan") String info,
                                       @RequestParam(value = "email", defaultValue = "test@test.ie") String email)
    {
        boolean isUpdated = storeData.updateAllData(id, info, email);
        if (!(isUpdated))
            return "The entire data has not been updated in the specified ID";
        return "The entire data has been updated in the specified ID";
    }

    // PATCH
    // Replaces partial amount of the data
    @PatchMapping(value = "/updateGreetingData/{id}")
    public String patchGreeting(@PathVariable int id, @RequestParam(value = "info", defaultValue = "Hello, My name is Ethan") String info)
    {
        boolean isUpdated = storeData.updateGreetingData(id, info);
        if (!(isUpdated))
            return "The Greeting has not been updated in the specified ID";
        return "The Greeting has been updated in the specified ID";
    }

    // PATCH
    // Replaces partial amount of the data
    @PatchMapping(value = "/updateEmailData/{id}")
    public String patchEmail(@PathVariable int id, @RequestParam(value = "email", defaultValue = "test@test.ie") String email)
    {
        boolean isUpdated = storeData.updateEmailData(id, email);
        if (!(isUpdated))
            return "The email has not been updated in the specified ID";
        return "The email has been updated in the specified ID";
    }
}
