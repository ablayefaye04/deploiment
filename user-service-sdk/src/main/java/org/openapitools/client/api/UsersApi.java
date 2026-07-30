package org.openapitools.client.api;

import org.openapitools.client.ApiClient;
import org.openapitools.client.BaseApi;

import org.openapitools.client.model.CreateUserRequest;
import org.openapitools.client.model.ErrorResponse;
import java.util.UUID;
import org.openapitools.client.model.UpdateUserRequest;
import org.openapitools.client.model.User;
import org.openapitools.client.model.UserPage;
import org.openapitools.client.model.UserType;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-07-30T10:49:02.701015900Z[Africa/Sao_Tome]", comments = "Generator version: 7.24.0")
public class UsersApi extends BaseApi {

    public UsersApi() {
        super(new ApiClient());
    }

    public UsersApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Créer un profil utilisateur
     * Création d&#39;un profil métier après création de l&#39;utilisateur dans Keycloak. 
     * <p><b>201</b> - Profil créé
     * <p><b>400</b> - Requête invalide
     * <p><b>409</b> - Utilisateur déjà existant
     * <p><b>401</b> - Authentification requise ou jeton invalide
     * <p><b>403</b> - AccÃ¨s refusÃ©
     * @param createUserRequest  (required)
     * @return User
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public User createUser(CreateUserRequest createUserRequest) throws RestClientException {
        return createUserWithHttpInfo(createUserRequest).getBody();
    }

    /**
     * Créer un profil utilisateur
     * Création d&#39;un profil métier après création de l&#39;utilisateur dans Keycloak. 
     * <p><b>201</b> - Profil créé
     * <p><b>400</b> - Requête invalide
     * <p><b>409</b> - Utilisateur déjà existant
     * <p><b>401</b> - Authentification requise ou jeton invalide
     * <p><b>403</b> - AccÃ¨s refusÃ©
     * @param createUserRequest  (required)
     * @return ResponseEntity&lt;User&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<User> createUserWithHttpInfo(CreateUserRequest createUserRequest) throws RestClientException {
        Object localVarPostBody = createUserRequest;
        
        // verify the required parameter 'createUserRequest' is set
        if (createUserRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'createUserRequest' when calling createUser");
        }
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<User> localReturnType = new ParameterizedTypeReference<User>() {};
        return apiClient.invokeAPI("/users", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Supprimer un utilisateur
     * 
     * <p><b>204</b> - Utilisateur supprimé
     * <p><b>400</b> - Requête invalide
     * <p><b>404</b> - Ressource introuvable
     * <p><b>401</b> - Authentification requise ou jeton invalide
     * <p><b>403</b> - AccÃ¨s refusÃ©
     * @param userId  (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteUser(UUID userId) throws RestClientException {
        deleteUserWithHttpInfo(userId);
    }

    /**
     * Supprimer un utilisateur
     * 
     * <p><b>204</b> - Utilisateur supprimé
     * <p><b>400</b> - Requête invalide
     * <p><b>404</b> - Ressource introuvable
     * <p><b>401</b> - Authentification requise ou jeton invalide
     * <p><b>403</b> - AccÃ¨s refusÃ©
     * @param userId  (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteUserWithHttpInfo(UUID userId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'userId' when calling deleteUser");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("userId", userId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Void> localReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/users/{userId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Récupérer le profil de l&#39;utilisateur connecté
     * 
     * <p><b>200</b> - Profil courant
     * <p><b>401</b> - Authentification requise ou jeton invalide
     * <p><b>403</b> - AccÃ¨s refusÃ©
     * @return User
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public User getCurrentUser() throws RestClientException {
        return getCurrentUserWithHttpInfo().getBody();
    }

    /**
     * Récupérer le profil de l&#39;utilisateur connecté
     * 
     * <p><b>200</b> - Profil courant
     * <p><b>401</b> - Authentification requise ou jeton invalide
     * <p><b>403</b> - AccÃ¨s refusÃ©
     * @return ResponseEntity&lt;User&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<User> getCurrentUserWithHttpInfo() throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<User> localReturnType = new ParameterizedTypeReference<User>() {};
        return apiClient.invokeAPI("/users/me", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Obtenir un utilisateur par ID
     * 
     * <p><b>200</b> - Utilisateur trouvé
     * <p><b>400</b> - Requête invalide
     * <p><b>404</b> - Ressource introuvable
     * <p><b>401</b> - Authentification requise ou jeton invalide
     * <p><b>403</b> - AccÃ¨s refusÃ©
     * @param userId  (required)
     * @return User
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public User getUserById(UUID userId) throws RestClientException {
        return getUserByIdWithHttpInfo(userId).getBody();
    }

    /**
     * Obtenir un utilisateur par ID
     * 
     * <p><b>200</b> - Utilisateur trouvé
     * <p><b>400</b> - Requête invalide
     * <p><b>404</b> - Ressource introuvable
     * <p><b>401</b> - Authentification requise ou jeton invalide
     * <p><b>403</b> - AccÃ¨s refusÃ©
     * @param userId  (required)
     * @return ResponseEntity&lt;User&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<User> getUserByIdWithHttpInfo(UUID userId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'userId' when calling getUserById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("userId", userId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<User> localReturnType = new ParameterizedTypeReference<User>() {};
        return apiClient.invokeAPI("/users/{userId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Rechercher les utilisateurs
     * 
     * <p><b>200</b> - Liste paginée des utilisateurs
     * <p><b>400</b> - Requête invalide
     * <p><b>401</b> - Authentification requise ou jeton invalide
     * <p><b>403</b> - AccÃ¨s refusÃ©
     * @param name  (optional)
     * @param email  (optional)
     * @param type  (optional)
     * @param page  (optional, default to 0)
     * @param size  (optional, default to 20)
     * @return UserPage
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public UserPage searchUsers(String name, String email, UserType type, Integer page, Integer size) throws RestClientException {
        return searchUsersWithHttpInfo(name, email, type, page, size).getBody();
    }

    /**
     * Rechercher les utilisateurs
     * 
     * <p><b>200</b> - Liste paginée des utilisateurs
     * <p><b>400</b> - Requête invalide
     * <p><b>401</b> - Authentification requise ou jeton invalide
     * <p><b>403</b> - AccÃ¨s refusÃ©
     * @param name  (optional)
     * @param email  (optional)
     * @param type  (optional)
     * @param page  (optional, default to 0)
     * @param size  (optional, default to 20)
     * @return ResponseEntity&lt;UserPage&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<UserPage> searchUsersWithHttpInfo(String name, String email, UserType type, Integer page, Integer size) throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "email", email));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "type", type));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<UserPage> localReturnType = new ParameterizedTypeReference<UserPage>() {};
        return apiClient.invokeAPI("/users", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Modifier son propre profil
     * 
     * <p><b>200</b> - Profil mis à jour
     * <p><b>400</b> - Requête invalide
     * <p><b>401</b> - Authentification requise ou jeton invalide
     * <p><b>403</b> - AccÃ¨s refusÃ©
     * @param updateUserRequest  (required)
     * @return User
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public User updateCurrentUser(UpdateUserRequest updateUserRequest) throws RestClientException {
        return updateCurrentUserWithHttpInfo(updateUserRequest).getBody();
    }

    /**
     * Modifier son propre profil
     * 
     * <p><b>200</b> - Profil mis à jour
     * <p><b>400</b> - Requête invalide
     * <p><b>401</b> - Authentification requise ou jeton invalide
     * <p><b>403</b> - AccÃ¨s refusÃ©
     * @param updateUserRequest  (required)
     * @return ResponseEntity&lt;User&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<User> updateCurrentUserWithHttpInfo(UpdateUserRequest updateUserRequest) throws RestClientException {
        Object localVarPostBody = updateUserRequest;
        
        // verify the required parameter 'updateUserRequest' is set
        if (updateUserRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'updateUserRequest' when calling updateCurrentUser");
        }
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<User> localReturnType = new ParameterizedTypeReference<User>() {};
        return apiClient.invokeAPI("/users/me", HttpMethod.PATCH, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Modifier un utilisateur
     * 
     * <p><b>200</b> - Utilisateur modifié
     * <p><b>400</b> - Requête invalide
     * <p><b>404</b> - Ressource introuvable
     * <p><b>401</b> - Authentification requise ou jeton invalide
     * <p><b>403</b> - AccÃ¨s refusÃ©
     * <p><b>409</b> - Conflit avec une ressource existante
     * @param userId  (required)
     * @param updateUserRequest  (required)
     * @return User
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public User updateUser(UUID userId, UpdateUserRequest updateUserRequest) throws RestClientException {
        return updateUserWithHttpInfo(userId, updateUserRequest).getBody();
    }

    /**
     * Modifier un utilisateur
     * 
     * <p><b>200</b> - Utilisateur modifié
     * <p><b>400</b> - Requête invalide
     * <p><b>404</b> - Ressource introuvable
     * <p><b>401</b> - Authentification requise ou jeton invalide
     * <p><b>403</b> - AccÃ¨s refusÃ©
     * <p><b>409</b> - Conflit avec une ressource existante
     * @param userId  (required)
     * @param updateUserRequest  (required)
     * @return ResponseEntity&lt;User&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<User> updateUserWithHttpInfo(UUID userId, UpdateUserRequest updateUserRequest) throws RestClientException {
        Object localVarPostBody = updateUserRequest;
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'userId' when calling updateUser");
        }
        
        // verify the required parameter 'updateUserRequest' is set
        if (updateUserRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'updateUserRequest' when calling updateUser");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("userId", userId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<User> localReturnType = new ParameterizedTypeReference<User>() {};
        return apiClient.invokeAPI("/users/{userId}", HttpMethod.PATCH, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }

    @Override
    public <T> ResponseEntity<T> invokeAPI(String url, HttpMethod method, Object request, ParameterizedTypeReference<T> returnType) throws RestClientException {
        String localVarPath = url.replace(apiClient.getBasePath(), "");
        Object localVarPostBody = request;

        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        return apiClient.invokeAPI(localVarPath, method, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, returnType);
    }
}
