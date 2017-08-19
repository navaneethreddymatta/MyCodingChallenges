package nav.codeChallenges;

import java.util.*;

/**
 * Created by navanee on 23-07-2017.
 */
public class FriendOfFriends {
    public static void main(String[] args) {
        Scanner inscanner = new Scanner(System.in);
        int numFriends = inscanner.nextInt();

        Set<String> friends = new HashSet<>();
        Set<String> friendOfFriends = new HashSet<>();
        if(numFriends > 0) {
            inscanner.nextLine();
        }
        for(int i = 0; i < numFriends; i++){
            String friendCircle = inscanner.nextLine();
            String[] friendsOfFriend = friendCircle.split(" ");
            friends.add(friendsOfFriend[0].trim());
            if(friendOfFriends.contains(friendsOfFriend[0].trim())) {
                friendOfFriends.remove(friendsOfFriend[0].trim());
            }
            for(int j = 2; j < friendsOfFriend.length; j++) {
                if(!friends.contains(friendsOfFriend[j].trim())) {
                    friendOfFriends.add(friendsOfFriend[j].trim());
                }
            }
        }
        System.out.println(friendOfFriends.size());
    }
}


/**
 3
 2334 5 1256 4323 7687 3244 5678
 1256 2 2334 7687
 4323 5 2334 5678 6547 9766 9543
 */