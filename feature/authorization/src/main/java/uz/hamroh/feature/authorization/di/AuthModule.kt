package uz.hamroh.feature.authorization.di

import android.content.Context
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import uz.hamroh.feature.authorization.BuildConfig
import uz.hamroh.feature.authorization.data.AuthApi
import uz.hamroh.feature.authorization.data.repository.AuthImpl
import uz.hamroh.feature.authorization.data.repository.AuthRepository
import uz.hamroh.feature.authorization.ui.AuthNavigationImpl
import uz.hamroh.navigation.AppCoordinator
import uz.hamroh.navigation.AuthNavigation
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {
    @Singleton
    @Provides
    fun provideAuth(appCoordinator: AppCoordinator): AuthNavigation =
        AuthNavigationImpl(appCoordinator)

    @Singleton
    @Provides
    fun provideAuthApi(retrofit: Retrofit): AuthApi =
        retrofit.create(AuthApi::class.java)

    @Singleton
    @Provides
    fun provideAuthRepository(authApi: AuthApi): AuthRepository = AuthImpl(authApi)


    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class SignIn

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class SignUp

    @Provides
    @Singleton
    fun provideGoogleSignInClient(@ApplicationContext context: Context): GoogleSignInClient =
        GoogleSignIn.getClient(
            context,
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .requestIdToken(BuildConfig.CLIENT_ID)
                .build()
        )

    @Provides
    @Singleton
    fun provideOneTapClient(@ApplicationContext context: Context): SignInClient =
        Identity.getSignInClient(context)


    @Singleton
    @SignIn
    @Provides
    fun provideOneSignInRequest(): BeginSignInRequest =
        BeginSignInRequest.builder()
            .setPasswordRequestOptions(
                BeginSignInRequest.PasswordRequestOptions.builder()
                    .setSupported(true)
                    .build()
            )
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setServerClientId(
                        BuildConfig.CLIENT_ID
                    )
                    .setFilterByAuthorizedAccounts(false)
                    .build()
            )
            .setAutoSelectEnabled(false)
            .build()

    @Singleton
    @SignUp
    @Provides
    fun provideOneTapSignUpRequest(): BeginSignInRequest =
        BeginSignInRequest.builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setServerClientId(
                        BuildConfig.CLIENT_ID
                    )
                    .setFilterByAuthorizedAccounts(false)
                    .build()
            ).build()
}
