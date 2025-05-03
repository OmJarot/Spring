package spring_web_mvc.Service;

import org.springframework.stereotype.Service;

@Service//otomatis diregistrasikan menjadi bean
public class HelloServiceImpl implements HelloService{//untuk menggunakannya, bisa langung menggunakan interfacenya

    @Override
    public String hello(String name) {
        if (name == null){
            return "Hello guest";
        }else {
            return "Hello " + name;
        }
    }
}
