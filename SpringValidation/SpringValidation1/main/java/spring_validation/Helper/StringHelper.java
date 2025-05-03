package spring_validation.Helper;

import org.springframework.stereotype.Component;

@Component
public class StringHelper {
    //palindrome adalah jika kata di balik  akan menghasilkan kata yang sama, contoh kodok dibalik menjadi kodok

    public boolean isPalindrome(String value){
        String palindrome = new StringBuilder(value).reverse().toString();
        return value.equals(palindrome);
    }

}
