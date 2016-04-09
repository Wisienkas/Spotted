package io.mlh.spotted.spotted.Model;

import com.parse.ParseUser;

import java.util.List;

/**
 * We can never have more than 1 user on the app at the same time
 * Therefore we might as well just have a static variable to have that user
 *
 * Created by wisienkas on 4/9/16.
 */
public class User {
    public static ParseUser user;
}
