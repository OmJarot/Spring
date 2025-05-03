package spring_aop.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect//dijadikan sebagai aspect
@Component
public class LogAspect {

    @Pointcut("target(spring_aop.AOP.HelloService)")//targetnya adalah semua method yang ada di HelloService
    public void helloServiceMethod(){//method ini sebagai identitas
    }

    //advice
    @Before("helloServiceMethod()")//before ini akan di eksekusi sebelum semua point cart terpenuhi, setiap manggil method di HelloService advice before ini akan dieksekusi
    public void beforeHelloServiceMethod(){
        log.info("Before HelloService Method");
    }

    //advice parameter
    @Before("helloServiceMethod()")
    public void beforeHelloServiceMethod2(JoinPoint point){
        String name = point.getTarget().getClass().getName();//mendapatkan nama classnya
        String method = point.getSignature().getName();//mendapatkan nama methodnya
        log.info("Before "+ name+"."+method+"()");
    }

    //Proceeding Join Point
    @Around("helloServiceMethod()")
    public Object aroundHelloServiceMethod(ProceedingJoinPoint point) throws Throwable{
        String name = point.getTarget().getClass().getName();
        String method = point.getSignature().getName();
        try {
            log.info("Around before "+ name+"."+method);//akan dipanggil sebelum method dijalankan
            return point.proceed(point.getArgs());//memanggil method aslinya
        }catch (Throwable throwable){
            log.info("Around error "+ name+"."+method);//dipanggil jika error
            throw throwable;
        }finally {
            log.info("Around finally "+ name+"."+method);//dipanggil jika semua method berhasil atau error
        }
    }

    //Pointcut Expression Format
    @Pointcut("execution(* spring_aop.AOP.HelloService.*(java.lang.String))")//dijalankan oleh semua method class helloService dengan access modifier bebas, dan yang memiliki parameter String
    public void pointcutHelloServiceParam(){}

    @Before("pointcutHelloServiceParam()")
    public void beforeParam(JoinPoint point){
        String value = (String) point.getArgs()[0];
        log.info("Execute method with parameter : "+value);
    }

    //multiple pointcut
    @Pointcut("execution(* spring_aop.AOP.*.*(..))")//semua method yang ada di package aop
    public void pointcutServicePackage(){}

    @Pointcut("bean(*Service)")//semua bean yang belakangnya ada "Service"
    public void pointcutServiceBean(){}

    @Pointcut("execution(public * * (..))")//semua method yang public
    public void pointcutServiceMethod(){}

    @Pointcut("pointcutServicePackage() && pointcutServiceBean() && pointcutServiceMethod()")//gabungan
    public void publicMethodForService(){}

    @Before("publicMethodForService()")
    public void logAllServiceMethod(){
        log.info("Log for all service method");
    }

    //passing parameter
    //mengambil value paramter nya secara langsung
    @Before("pointcutHelloServiceParam() && args(name)")//name akan otomatis di kirim ke paramter
    public void beforeParamPassing(String name){
        log.info("Execute method with parameter : "+ name);
    }

}
//join point
//Eksekusi method hello() di class HelloService
//Eksekusi semua method public di class HelloService
//Eksekusi semua method yang terdapat annotation @Test
//Eksekusi method di package service yang throw Exception
//Dan lain-lain
//Intinya adalah titik lokasi eksekusi method dengan kriteria tertentu, sehingga bisa melintasi satu atau lebih method dan object

//point cut
//Pointcut merupakan kondisi yang digunakan untuk menentukan Join Point
//Dan ketika kondisi terpenuhi, maka Aspect akan mengeksekusi Advice (akan dibahas di materi sendiri)

//daftar point cut expresion
// execution :eksekusi method
//within :object sesuai yang ditentukan
//this :bean reference adalah instance tipe yang ditentukan
//target :object adalah instance dari tipe yang ditentukan
//args :argument method adalah instance dari tipe yang ditentukan
// @target :object memiliki annotation yang ditentukan
//@args :arguments method memiliki annotation yang ditentukan
//@within :method di object yang memiliki annotation yang ditentukan
//@annotation :method memiliki annotation yang ditentukan
//bean :object dengan nama bean sesuai yang ditentukan

//within(com.xyz.service.*) : Semua method di bean di package service
//within(com.xyz.service..*) : Semua method di bean di package service dan di sub package nya
//target(com.xyz.service.AccountService) : Semua method di bean AccountService
//args(java.lang.String, java.lang.String) : Semua method di bean yang memiliki dua parameter String
//@target(org.springframework.transaction.annotation.Transactional) : Semua method yang memiliki annotation Transactional
//bean(traceService) : Semua method di bean dengan nama traceService
//bean(*Service) : Semua method di bean dengan akhiran Service

//execution(public * *(..)) : Semua method public
//execution(* set*(..)) : Semua method dengan prefix set
//execution(* com.xyz.service.AccountService.*(..)) : Semua method di class AccountService
//execution(* com.xyz.service.*.*(..)) : Semua method di package service
//execution(* com.xyz.service..*.*(..)) : Semua method di package service dan sub package nya

//advice
//Advice adalah aksi yang yang dilakukan oleh Aspect pada Join Point
// Before: Aspect akan menjalankan aksi sebelum Join Point
//AfterReturning: Aspect akan menjalankan aksi setelah Join Point return secara normal
//AfterThrowing: Aspect akan menjalankan aksi setelah Joint Point throw exception
//After: Aspect akan menjalankan aksi setelah selesai Join Point, After harus bisa menangani return normal atau throw exception
//Around: Aspect memiliki kesempatan untuk menjalankan aksi sebelum dan setelah
