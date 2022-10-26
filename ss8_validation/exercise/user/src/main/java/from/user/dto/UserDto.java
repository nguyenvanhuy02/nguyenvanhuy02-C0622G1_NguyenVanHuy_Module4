package from.user.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class UserDto implements Validator {

    private int id;
    @NotBlank(message = "Không được để trống !")
    private String name;
    @Valid
    @NotNull
    private Integer age;
    @NotBlank(message = "Không được để trống !")
    private String email;
    @NotBlank(message = "Không được để trống !")
    private String phoneNumber;

    public UserDto() {
    }

    public UserDto(int id, String name, Integer age, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;

        if (!userDto.getName().matches("^[a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{5,50}$") && !userDto.getName().equals("")){
            errors.rejectValue("name","name.forbidden","Tên phải đúng định dạng !");
        }
        if ( !(userDto.getAge() >= 18) && !(userDto.getAge() == null)){
            errors.rejectValue("age","age.forbidden","Phải trên 18 tuổi!");
        }

        if (!userDto.getEmail().matches("[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)") && !userDto.getEmail().equals("")){
            errors.rejectValue("email","email.forbidden","Không đúng định dạng !");
        }
        if (!userDto.getPhoneNumber().matches("[0][0-9]{9}") && !userDto.getPhoneNumber().equals("")){
            errors.rejectValue("phoneNumber","phone.forbidden","Số điện thoại không đúng định dạng !");
        }
    }
}
