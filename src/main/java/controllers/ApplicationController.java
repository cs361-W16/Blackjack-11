/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;

import models.BlackJack;
import models.Dealer;
import ninja.Context;
import ninja.Result;
import ninja.Results;

import com.google.inject.Singleton;
import ninja.params.PathParam;


@Singleton
public class ApplicationController {

    public Result index() {
        return Results.html();
    }

    public Result blackJack() {
        return Results.html().template("views/BlackJack/BlackJack.flt.html");
    }

    public Result gameGet(){
        BlackJack g = new BlackJack();

        return Results.json().render(g);
    }

    public Result gameHit(BlackJack g){
        return Results.json().render(g);
    }

    public Result gameStay(BlackJack g){

        return Results.json().render(g);
    }

    public Result gameDouble(BlackJack g){

        return Results.json().render(g);
    }

}
