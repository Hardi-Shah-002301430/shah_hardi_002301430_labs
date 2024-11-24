/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analytics;

/**
 *
 * @author harshalneelkamal
 */

import data.DataStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import model.Comment;
import model.Post;
import model.User;


public class AnalysisHelper {
    //Find Average number of likes per comment.
    //TODO
    public void getAverageLikesPerComments() {
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        int likeNumber = 0;
        int commentNumber = comments.size();
        for (Comment c : comments.values()) {
            likeNumber += c.getLikes();
        }
        
        System.out.println("Q1 - How many likes does each comment get on average? " + likeNumber / commentNumber);
            
    }
    public void getMaxLikeCommentPost () {
        DataStore data = DataStore.getInstance () ;
        Comment commentwithMaxLikes = null;
        for (Comment c : data.getComments () .values ()) {
        if (commentwithMaxLikes == null) {
            commentwithMaxLikes = c;
        }
        if (c. getLikes () > commentwithMaxLikes.getLikes ()) {
        commentwithMaxLikes = c;
        }
        }
        int postid = commentwithMaxLikes.getPostId () ;
        System.out.println("Q2 - Which post has the most likes per comment?" + data.getPosts ().get (postid).toString ());
        

        }
    
    public void getPostwithMostComments () {
        DataStore data = DataStore.getInstance () ;
        Post postwithMostComments = null;
        for (Post p:data.getPosts().values()){
            if (postwithMostComments == null) {
                postwithMostComments = p;
            }
        if (p.getComments ().size () > postwithMostComments.getComments ().size ()) {
        postwithMostComments = p;
        }
        }
        System.out.println("Q3 - Which post has the most comments?" + postwithMostComments.getPostId () ) ;
}

    public void getPassiveUsers () {
        DataStore data = DataStore. getInstance () ;
        HashMap<Integer, Integer> postNumbers = new HashMap<Integer, Integer> () ;
        for (Post p: data.getPosts () . values ()) {
        int userId = p.getUserId () ;
        if (postNumbers. containsKey (userId) ) {
            postNumbers.put (userId, postNumbers.get (userId) + 1);
        } else {
        postNumbers.put(userId, 1) ;
        }
        }
        ArrayList<User> users = new ArrayList (data.getUsers ().values () ) ;
        Collections.sort (users, new UserMapComparator (postNumbers)) ;
        System.out.println("Q4 - Which users have the fewest posts? ");
        
        for (int i = 0; i < 5; i++) {
            System.out.println(users.get (i) +", - Post count: " + postNumbers.get (users.get (i) .getId() )) ;
        
        }
        
    }
    
    public void getPassiveCommentUsers () {
        DataStore data = DataStore. getInstance () ;
        HashMap<Integer, Integer> commentNumbers = new HashMap<Integer, Integer> () ;
        for (Comment c : data.getComments () . values ()) {
        int userId = c.getUserId () ;
        if (commentNumbers.containsKey (userId)) {
        commentNumbers. put (userId, commentNumbers. get (userId) + 1);
        } else {
            commentNumbers. put (userId, 1) ;
        }
        }
        ArrayList<User> users = new ArrayList (data. getUsers () .values ()) ;
        Collections.sort(users, new UserMapComparator (commentNumbers) ) ;
        System.out.println("Q5 - The following users have the least comments: ");
        for (int i = 0; i < 5; i++) {
        System.out.println (users.get (i) + " ,- Comment count: " + commentNumbers.get (users.get (i) .getId()) );
        }
        
        
    }
        
    public void getPassiveAndActiveOverallUsers() {
        DataStore dataStore = DataStore.getInstance();
        HashMap<Integer, Integer> userActivityCounts = new HashMap<>();

        // Calculate activity counts based on comments
        for (Comment comment : dataStore.getComments().values()) {
            int userId = comment.getUserId();
            userActivityCounts.put(userId, userActivityCounts.getOrDefault(userId, 0) + 1 + comment.getLikes());
        }

        // Calculate activity counts based on posts
        for (Post post : dataStore.getPosts().values()) {
            int userId = post.getUserId();
            userActivityCounts.put(userId, userActivityCounts.getOrDefault(userId, 0) + 1);
        }

        // Create a list of users and sort based on activity counts
        ArrayList<User> users = new ArrayList<>(dataStore.getUsers().values());
        Collections.sort(users, new UserMapComparator(userActivityCounts));

        // Display the least active users
        System.out.println("Q6 - Which users are the least active?");
        for (int i = 0; i < 5 && i < users.size(); i++) {
            User user = users.get(i);
            System.out.println(user + ", - Overall count: " + userActivityCounts.get(user.getId()));
        }

        // Display the most active users
        System.out.println("Q7 - Which users are the most active?");
        for (int i = users.size() - 1; i >= users.size() - 5 && i >= 0; i--) {
            User user = users.get(i);
            System.out.println(user + ", - Overall count: " + userActivityCounts.get(user.getId()));
        }
    }
}
