package sn.uasz.alumni.userservice.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sn.uasz.alumni.userservice.exception.ApiExceptions;
import sn.uasz.alumni.userservice.model.*;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class UserController {

    private final Map<UUID, User> store = new ConcurrentHashMap<>();
    private UUID currentUserId;

    public UserController() {
        seed();
    }

    // ---------- POST /users ----------
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody CreateUserRequest request) {
        boolean exists = store.values().stream()
                .anyMatch(u -> u.getEmail().equalsIgnoreCase(request.getEmail())
                        || u.getKeycloakId().equals(request.getKeycloakId()));
        if (exists) {
            throw new ApiExceptions.ConflictException("Un utilisateur avec cet email ou ce keycloakId existe deja");
        }

        User user = new User();
        user.setId(UUID.randomUUID());
        user.setKeycloakId(request.getKeycloakId());
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPhone(request.getPhone());
        user.setType(request.getType() != null ? request.getType() : UserType.STUDENT);
        user.setStatus(UserStatus.ACTIVE);
        user.setAddress(request.getAddress());
        user.setCreatedAt(OffsetDateTime.now());
        user.setUpdatedAt(OffsetDateTime.now());

        store.put(user.getId(), user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    // ---------- GET /users ----------
    @GetMapping("/users")
    public ResponseEntity<UserPage> searchUsers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) UserType type,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {

        List<User> filtered = store.values().stream()
                .filter(u -> name == null || (u.getFirstName() + " " + u.getLastName())
                        .toLowerCase().contains(name.toLowerCase()))
                .filter(u -> email == null || u.getEmail().equalsIgnoreCase(email))
                .filter(u -> type == null || u.getType() == type)
                .sorted(Comparator.comparing(User::getCreatedAt))
                .collect(Collectors.toList());

        int from = Math.min(page * size, filtered.size());
        int to = Math.min(from + size, filtered.size());
        List<User> pageContent = filtered.subList(from, to);

        return ResponseEntity.ok(new UserPage(pageContent, page, size, filtered.size()));
    }

    // ---------- GET /users/{userId} ----------
    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable UUID userId) {
        return ResponseEntity.ok(findOrThrow(userId));
    }

    // ---------- PATCH /users/{userId} ----------
    @PatchMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable UUID userId, @Valid @RequestBody UpdateUserRequest request) {
        User user = findOrThrow(userId);
        applyUpdate(user, request);
        return ResponseEntity.ok(user);
    }

    // ---------- DELETE /users/{userId} ----------
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID userId) {
        findOrThrow(userId);
        store.remove(userId);
        return ResponseEntity.noContent().build();
    }

    // ---------- GET /users/me ----------
    @GetMapping("/users/me")
    public ResponseEntity<User> getCurrentUser() {
        return ResponseEntity.ok(findOrThrow(currentUserId));
    }

    // ---------- PATCH /users/me ----------
    @PatchMapping("/users/me")
    public ResponseEntity<User> updateCurrentUser(@Valid @RequestBody UpdateUserRequest request) {
        User user = findOrThrow(currentUserId);
        applyUpdate(user, request);
        return ResponseEntity.ok(user);
    }

    // ---------- Helpers ----------
    private User findOrThrow(UUID id) {
        User user = store.get(id);
        if (user == null) {
            throw new ApiExceptions.NotFoundException("Utilisateur introuvable : " + id);
        }
        return user;
    }

    private void applyUpdate(User user, UpdateUserRequest request) {
        if (request.getFirstName() != null) user.setFirstName(request.getFirstName());
        if (request.getLastName() != null) user.setLastName(request.getLastName());
        if (request.getPhone() != null) user.setPhone(request.getPhone());
        if (request.getBiography() != null) user.setBiography(request.getBiography());
        if (request.getPhotoUrl() != null) user.setPhotoUrl(request.getPhotoUrl());
        if (request.getAddress() != null) user.setAddress(request.getAddress());
        user.setUpdatedAt(OffsetDateTime.now());
    }

    private void seed() {
        User alice = new User();
        alice.setId(UUID.randomUUID());
        alice.setKeycloakId("keycloak-abc-123");
        alice.setEmail("user1@example.com");
        alice.setFirstName("Alice");
        alice.setLastName("Martin");
        alice.setPhone("+33123456780");
        alice.setPhotoUrl("https://example.com/photos/alice.jpg");
        alice.setBiography("Professeure de mathematiques.");
        alice.setBirthDate(LocalDate.of(1975, 3, 20));
        alice.setGender(Gender.FEMALE);
        alice.setType(UserType.TEACHER);
        alice.setStatus(UserStatus.ACTIVE);
        Address addr1 = new Address();
        addr1.setCountry("France");
        addr1.setCity("Lyon");
        addr1.setStreet("12 avenue des Champs");
        addr1.setPostalCode("69000");
        alice.setAddress(addr1);
        alice.setCreatedAt(OffsetDateTime.parse("2022-01-01T10:00:00Z"));
        alice.setUpdatedAt(OffsetDateTime.parse("2023-01-01T10:00:00Z"));
        store.put(alice.getId(), alice);

        User bob = new User();
        bob.setId(UUID.randomUUID());
        bob.setKeycloakId("keycloak-def-456");
        bob.setEmail("user2@example.com");
        bob.setFirstName("Bob");
        bob.setLastName("Durand");
        bob.setPhone("+33123456781");
        bob.setPhotoUrl("https://example.com/photos/bob.jpg");
        bob.setBiography("Etudiant en informatique.");
        bob.setBirthDate(LocalDate.of(1998, 7, 15));
        bob.setGender(Gender.MALE);
        bob.setType(UserType.STUDENT);
        bob.setStatus(UserStatus.ACTIVE);
        Address addr2 = new Address();
        addr2.setCountry("France");
        addr2.setCity("Marseille");
        addr2.setStreet("5 rue de la Republique");
        addr2.setPostalCode("13000");
        bob.setAddress(addr2);
        bob.setCreatedAt(OffsetDateTime.parse("2022-06-01T10:00:00Z"));
        bob.setUpdatedAt(OffsetDateTime.parse("2023-06-01T10:00:00Z"));
        store.put(bob.getId(), bob);

        // Utilisateur utilise par /users/me
        this.currentUserId = alice.getId();
    }
}
