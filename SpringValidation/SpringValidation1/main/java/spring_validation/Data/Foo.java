package spring_validation.Data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring_validation.Validation.Palindrome;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Foo {

    @Palindrome
    private String bar;

}
