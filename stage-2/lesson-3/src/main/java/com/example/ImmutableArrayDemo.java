package com.example;

import java.util.Arrays;

public class ImmutableArrayDemo {
    public static void main(String[] args) {
        User[] users=of(1L,2L,3L,4L);
        //浅copy
        User[] copy= Arrays.copyOf(users,users.length);
        copy[0].id=99L;

        System.out.println(Arrays.toString(users));

    }

    private static User[] of(Long... ids){
        User[] users=new User[ids.length];
        for(int i=0;i<ids.length;i++){
            users[i]=new User(ids[i]);
        }
        return users;
    }

    private static class User{
        public  Long id;

        private User(Long id){
            this.id=id;
        }

        public Long getId() {
            return id;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    '}';
        }
    }
}
