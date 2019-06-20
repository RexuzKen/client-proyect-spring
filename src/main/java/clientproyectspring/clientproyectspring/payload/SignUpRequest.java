package clientproyectspring.clientproyectspring.payload;

import javax.validation.constraints.*;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */

public class SignUpRequest {
	
    @NotBlank(message = "Nombre requerido.")
    @Size(min = 3, max = 40, message = "Nombre debe contener entre 3 a 40 caracteres.")
    private String name;

    @NotBlank(message = "Username requerido.")
    @Size(min = 3, max = 15, message = "Username debe contener entre 3 a 15 caracteres.")
    private String username;

    @NotBlank(message = "Email requerido.")
    @Size(max = 40, message = "Email debe contener un maximo de 40 caracteres.")
    @Email(message = "Email invalido.")
    private String email;

    @NotBlank(message = "Password requerida.")
    @Size(min = 6, max = 20, message = "Password debe contener entre 6 y 20 caracteres.")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
