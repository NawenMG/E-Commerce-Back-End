package com.my_app.my_app.dbRT.API.GraphQl.Controllers;

import com.my_app.my_app.dbRT.Collections.Chat;
import com.my_app.my_app.dbRT.Parametri.ParamQueryChat;
import com.my_app.my_app.dbRT.Repository.Classs.ChatRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Controller
public class ChatControllerGraphql {

    @Autowired
    private ChatRep chatRep;

    @QueryMapping
    public CompletableFuture<List<Chat>> getChats(@Argument ParamQueryChat params) {
        return chatRep.queryChats(params);
    }
}
