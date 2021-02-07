package com.example.assignmentdemoapp.Presentation.view.base

import android.app.Application
import com.example.assignmentdemoapp.Presentation.di.PostModule
import com.example.assignmentdemoapp.Presentation.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class UserApplication : Application() {

    companion object {
        private lateinit var instance: UserApplication

        fun getInstance(): UserApplication = instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin {
            androidLogger()
            androidContext(this@UserApplication)
            modules(
                listOf(
                    PostModule,
                    networkModule
                )
            )
        }
//        checkAppCredentials()
//        checkChatSettings()
//        initCredentials()
//
//        getTokenForFirebase()
    }

//    private fun checkAppCredentials() {
//        if (APPLICATION_ID.isEmpty() || AUTH_KEY.isEmpty() || AUTH_SECRET.isEmpty() || ACCOUNT_KEY.isEmpty()) {
//            throw AssertionError(getString(R.string.error_qb_credentials_empty))
//        }
//    }
//
//    private fun checkChatSettings() {
//        if (USER_DEFAULT_PASSWORD.isEmpty() || CHAT_PORT !in MIN_PORT_VALUE..MAX_PORT_VALUE
//            || SOCKET_TIMEOUT !in MIN_SOCKET_TIMEOUT..MAX_SOCKET_TIMEOUT
//        ) {
//            throw AssertionError(getString(R.string.error_chat_credentails_empty))
//        }
//    }
//
//    private fun initCredentials() {
//        QBSettings.getInstance().init(applicationContext, APPLICATION_ID, AUTH_KEY, AUTH_SECRET)
//        QBSettings.getInstance().accountKey = ACCOUNT_KEY
//
//        // Uncomment and put your Api and Chat servers endpoints if you want to point the sample
//        // against your own server.
//        //
//        // QBSettings.getInstance().setEndpoints("https://your_api_endpoint.com", "your_chat_endpoint", ServiceZone.PRODUCTION);
//        // QBSettings.getInstance().zone = ServiceZone.PRODUCTION
//    }
//
//    private fun getTokenForFirebase() {
//        FirebaseInstanceId.getInstance().instanceId
//            .addOnCompleteListener(OnCompleteListener { task ->
//                if (!task.isSuccessful) {
//                    Log.w("fcm token exc", "getInstanceId failed", task.exception)
//                    return@OnCompleteListener
//                }
//                // Get new Instance ID token
//                val token = task.result?.token
//                // Log and toast
//                SharedPrefsHelper.setFcmToken(token.toString())
//                Log.d("fcm token", token)
//
//            })
//    }


}