/**
 */

package petstore;

import java.util.List;
import okhttp3.Interceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import com.microsoft.rest.AutoRestBaseUrl;
import com.microsoft.rest.serializer.JacksonMapperAdapter;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceException;
import com.microsoft.rest.ServiceResponse;
import java.io.InputStream;
import java.io.IOException;
import java.util.Map;
import okhttp3.ResponseBody;
import petstore.models.Order;
import petstore.models.Pet;
import petstore.models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.HTTP;
import retrofit2.http.Path;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/**
 * The interface for SwaggerPetstore class.
 */
public interface SwaggerPetstore {
    /**
     * Gets the URL used as the base for all cloud service requests.
     *
     * @return the BaseUrl object.
     */
    AutoRestBaseUrl getBaseUrl();

    /**
     * Gets the list of interceptors the OkHttp client will execute.
     *
     * @return the list of interceptors.
     */
    List<Interceptor> getClientInterceptors();

    /**
     * Sets the logging level for OkHttp client.
     *
     * @param logLevel the logging level enum.
     */
    void setLogLevel(Level logLevel);

    /**
     * Gets the adapter for {@link com.fasterxml.jackson.databind.ObjectMapper} for serialization
     * and deserialization operations..
     *
     * @return the adapter.
     */
    JacksonMapperAdapter getMapperAdapter();

    /**
     * The interface defining all the services for SwaggerPetstore to be
     * used by Retrofit to perform actually REST calls.
     */
    interface SwaggerPetstoreService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("pet")
        Call<ResponseBody> addPetUsingByteArray(@Body String body);

        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("pet")
        Call<ResponseBody> addPet(@Body Pet body);

        @Headers("Content-Type: application/json; charset=utf-8")
        @PUT("pet")
        Call<ResponseBody> updatePet(@Body Pet body);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("pet/findByStatus")
        Call<ResponseBody> findPetsByStatus(@Query("status") String status);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("pet/findByTags")
        Call<ResponseBody> findPetsByTags(@Query("tags") String tags);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("pet/{petId}")
        Call<ResponseBody> findPetsWithByteArray(@Path("petId") long petId);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("pet/{petId}")
        Call<ResponseBody> getPetById(@Path("petId") long petId);

        @Headers("Content-Type: application/x-www-form-urlencoded")
        @POST("pet/{petId}")
        Call<ResponseBody> updatePetWithForm(@Path("petId") String petId, String name, String status);

        @Headers("Content-Type: application/json; charset=utf-8")
        @HTTP(path = "pet/{petId}", method = "DELETE", hasBody = true)
        Call<ResponseBody> deletePet(@Path("petId") long petId, @Header("api_key") String apiKey);

        @Headers("Content-Type: multipart/form-data")
        @POST("pet/{petId}/uploadImage")
        Call<ResponseBody> uploadFile(@Path("petId") long petId, String additionalMetadata, InputStream file);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("store/inventory")
        Call<ResponseBody> getInventory();

        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("store/order")
        Call<ResponseBody> placeOrder(@Body Order body);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("store/order/{orderId}")
        Call<ResponseBody> getOrderById(@Path("orderId") String orderId);

        @Headers("Content-Type: application/json; charset=utf-8")
        @HTTP(path = "store/order/{orderId}", method = "DELETE", hasBody = true)
        Call<ResponseBody> deleteOrder(@Path("orderId") String orderId);

        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("user")
        Call<ResponseBody> createUser(@Body User body);

        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("user/createWithArray")
        Call<ResponseBody> createUsersWithArrayInput(@Body List<User> body);

        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("user/createWithList")
        Call<ResponseBody> createUsersWithListInput(@Body List<User> body);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("user/login")
        Call<ResponseBody> loginUser(@Query("username") String username, @Query("password") String password);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("user/logout")
        Call<ResponseBody> logoutUser();

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("user/{username}")
        Call<ResponseBody> getUserByName(@Path("username") String username);

        @Headers("Content-Type: application/json; charset=utf-8")
        @PUT("user/{username}")
        Call<ResponseBody> updateUser(@Path("username") String username, @Body User body);

        @Headers("Content-Type: application/json; charset=utf-8")
        @HTTP(path = "user/{username}", method = "DELETE", hasBody = true)
        Call<ResponseBody> deleteUser(@Path("username") String username);

    }

    /**
     * Fake endpoint to test byte array in body parameter for adding a new pet to the store.
     *
     * @param body Pet object in the form of byte array
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> addPetUsingByteArray(String body) throws ServiceException, IOException;

    /**
     * Fake endpoint to test byte array in body parameter for adding a new pet to the store.
     *
     * @param body Pet object in the form of byte array
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> addPetUsingByteArrayAsync(String body, final ServiceCallback<Void> serviceCallback);
    /**
     * Add a new pet to the store.
     *
     * @param body Pet object that needs to be added to the store
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> addPet(Pet body) throws ServiceException, IOException;

    /**
     * Add a new pet to the store.
     *
     * @param body Pet object that needs to be added to the store
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> addPetAsync(Pet body, final ServiceCallback<Void> serviceCallback);
    /**
     * Update an existing pet.
     *
     * @param body Pet object that needs to be added to the store
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> updatePet(Pet body) throws ServiceException, IOException;

    /**
     * Update an existing pet.
     *
     * @param body Pet object that needs to be added to the store
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> updatePetAsync(Pet body, final ServiceCallback<Void> serviceCallback);
    /**
     * Finds Pets by status.
     * Multiple status values can be provided with comma seperated strings.
     *
     * @param status Status values that need to be considered for filter
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the List&lt;Pet&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<List<Pet>> findPetsByStatus(List<String> status) throws ServiceException, IOException;

    /**
     * Finds Pets by status.
     * Multiple status values can be provided with comma seperated strings.
     *
     * @param status Status values that need to be considered for filter
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> findPetsByStatusAsync(List<String> status, final ServiceCallback<List<Pet>> serviceCallback);
    /**
     * Finds Pets by tags.
     * Muliple tags can be provided with comma seperated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param tags Tags to filter by
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the List&lt;Pet&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<List<Pet>> findPetsByTags(List<String> tags) throws ServiceException, IOException;

    /**
     * Finds Pets by tags.
     * Muliple tags can be provided with comma seperated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param tags Tags to filter by
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> findPetsByTagsAsync(List<String> tags, final ServiceCallback<List<Pet>> serviceCallback);
    /**
     * Fake endpoint to test byte array return by 'Find pet by ID'.
     * Returns a pet when ID &lt; 10.  ID &gt; 10 or nonintegers will simulate API error conditions.
     *
     * @param petId ID of pet that needs to be fetched
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the String object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<String> findPetsWithByteArray(long petId) throws ServiceException, IOException;

    /**
     * Fake endpoint to test byte array return by 'Find pet by ID'.
     * Returns a pet when ID &lt; 10.  ID &gt; 10 or nonintegers will simulate API error conditions.
     *
     * @param petId ID of pet that needs to be fetched
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> findPetsWithByteArrayAsync(long petId, final ServiceCallback<String> serviceCallback);
    /**
     * Find pet by ID.
     * Returns a pet when ID &lt; 10.  ID &gt; 10 or nonintegers will simulate API error conditions.
     *
     * @param petId ID of pet that needs to be fetched
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the Pet object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<Pet> getPetById(long petId) throws ServiceException, IOException;

    /**
     * Find pet by ID.
     * Returns a pet when ID &lt; 10.  ID &gt; 10 or nonintegers will simulate API error conditions.
     *
     * @param petId ID of pet that needs to be fetched
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> getPetByIdAsync(long petId, final ServiceCallback<Pet> serviceCallback);
    /**
     * Updates a pet in the store with form data.
     *
     * @param petId ID of pet that needs to be updated
     * @param name Updated name of the pet
     * @param status Updated status of the pet
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> updatePetWithForm(String petId, String name, String status) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Updates a pet in the store with form data.
     *
     * @param petId ID of pet that needs to be updated
     * @param name Updated name of the pet
     * @param status Updated status of the pet
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> updatePetWithFormAsync(String petId, String name, String status, final ServiceCallback<Void> serviceCallback);
    /**
     * Deletes a pet.
     *
     * @param petId Pet id to delete
     * @param apiKey 
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> deletePet(long petId, String apiKey) throws ServiceException, IOException;

    /**
     * Deletes a pet.
     *
     * @param petId Pet id to delete
     * @param apiKey 
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> deletePetAsync(long petId, String apiKey, final ServiceCallback<Void> serviceCallback);
    /**
     * uploads an image.
     *
     * @param petId ID of pet to update
     * @param additionalMetadata Additional data to pass to server
     * @param file file to upload
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> uploadFile(long petId, String additionalMetadata, InputStream file) throws ServiceException, IOException;

    /**
     * uploads an image.
     *
     * @param petId ID of pet to update
     * @param additionalMetadata Additional data to pass to server
     * @param file file to upload
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> uploadFileAsync(long petId, String additionalMetadata, InputStream file, final ServiceCallback<Void> serviceCallback);
    /**
     * Returns pet inventories by status.
     * Returns a map of status codes to quantities.
     *
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the Map&lt;String, Integer&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<Map<String, Integer>> getInventory() throws ServiceException, IOException;

    /**
     * Returns pet inventories by status.
     * Returns a map of status codes to quantities.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> getInventoryAsync(final ServiceCallback<Map<String, Integer>> serviceCallback);
    /**
     * Place an order for a pet.
     *
     * @param body order placed for purchasing the pet
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the Order object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<Order> placeOrder(Order body) throws ServiceException, IOException;

    /**
     * Place an order for a pet.
     *
     * @param body order placed for purchasing the pet
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> placeOrderAsync(Order body, final ServiceCallback<Order> serviceCallback);
    /**
     * Find purchase order by ID.
     * For valid response try integer IDs with value &lt;= 5 or &gt; 10. Other values will generated exceptions.
     *
     * @param orderId ID of pet that needs to be fetched
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the Order object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<Order> getOrderById(String orderId) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Find purchase order by ID.
     * For valid response try integer IDs with value &lt;= 5 or &gt; 10. Other values will generated exceptions.
     *
     * @param orderId ID of pet that needs to be fetched
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> getOrderByIdAsync(String orderId, final ServiceCallback<Order> serviceCallback);
    /**
     * Delete purchase order by ID.
     * For valid response try integer IDs with value &lt; 1000. Anything above 1000 or nonintegers will generate API errors.
     *
     * @param orderId ID of the order that needs to be deleted
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> deleteOrder(String orderId) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Delete purchase order by ID.
     * For valid response try integer IDs with value &lt; 1000. Anything above 1000 or nonintegers will generate API errors.
     *
     * @param orderId ID of the order that needs to be deleted
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> deleteOrderAsync(String orderId, final ServiceCallback<Void> serviceCallback);
    /**
     * Create user.
     * This can only be done by the logged in user.
     *
     * @param body Created user object
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> createUser(User body) throws ServiceException, IOException;

    /**
     * Create user.
     * This can only be done by the logged in user.
     *
     * @param body Created user object
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> createUserAsync(User body, final ServiceCallback<Void> serviceCallback);
    /**
     * Creates list of users with given input array.
     *
     * @param body List of user object
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> createUsersWithArrayInput(List<User> body) throws ServiceException, IOException;

    /**
     * Creates list of users with given input array.
     *
     * @param body List of user object
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> createUsersWithArrayInputAsync(List<User> body, final ServiceCallback<Void> serviceCallback);
    /**
     * Creates list of users with given input array.
     *
     * @param body List of user object
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> createUsersWithListInput(List<User> body) throws ServiceException, IOException;

    /**
     * Creates list of users with given input array.
     *
     * @param body List of user object
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> createUsersWithListInputAsync(List<User> body, final ServiceCallback<Void> serviceCallback);
    /**
     * Logs user into the system.
     *
     * @param username The user name for login
     * @param password The password for login in clear text
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the String object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<String> loginUser(String username, String password) throws ServiceException, IOException;

    /**
     * Logs user into the system.
     *
     * @param username The user name for login
     * @param password The password for login in clear text
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> loginUserAsync(String username, String password, final ServiceCallback<String> serviceCallback);
    /**
     * Logs out current logged in user session.
     *
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> logoutUser() throws ServiceException, IOException;

    /**
     * Logs out current logged in user session.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> logoutUserAsync(final ServiceCallback<Void> serviceCallback);
    /**
     * Get user by user name.
     *
     * @param username The name that needs to be fetched. Use user1 for testing. 
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the User object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<User> getUserByName(String username) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get user by user name.
     *
     * @param username The name that needs to be fetched. Use user1 for testing. 
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> getUserByNameAsync(String username, final ServiceCallback<User> serviceCallback);
    /**
     * Updated user.
     * This can only be done by the logged in user.
     *
     * @param username name that need to be deleted
     * @param body Updated user object
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> updateUser(String username, User body) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Updated user.
     * This can only be done by the logged in user.
     *
     * @param username name that need to be deleted
     * @param body Updated user object
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> updateUserAsync(String username, User body, final ServiceCallback<Void> serviceCallback);
    /**
     * Delete user.
     * This can only be done by the logged in user.
     *
     * @param username The name that needs to be deleted
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> deleteUser(String username) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Delete user.
     * This can only be done by the logged in user.
     *
     * @param username The name that needs to be deleted
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> deleteUserAsync(String username, final ServiceCallback<Void> serviceCallback);

}