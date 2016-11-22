package utils;

import Pages.*;

/**
 * Created by nykytchuk on 21/11/2016.
 */
public class PageProvider {

    private LoginPage loginPage = null;
    private ProfilePage profilePage = null;
    private SignUpPage signUpPage = null;
    private MainPage mainPage = null;
    private LoginOptionsPage optionsPage = null;



    public LoginPage Login(){
        if (loginPage ==null){
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public ProfilePage Profile(){
        if(profilePage == null){
            profilePage = new ProfilePage();
        }
        return profilePage;
    }

    public SignUpPage SignUp(){
        if(signUpPage == null){
            signUpPage = new SignUpPage();
        }
        return signUpPage;
    }

    public MainPage Main(){
        if(mainPage == null){
            mainPage = new MainPage();
        }
        return mainPage;
    }

    public LoginOptionsPage LoginOptions(){
        if (optionsPage ==null){
            optionsPage = new LoginOptionsPage();
        }
        return optionsPage;
    }


    public void getToLoginPage(){
        Main().GetToUserProfile();
        LoginOptions().logInWithEmail();
        SignUp().LogInClick();
    }



}
