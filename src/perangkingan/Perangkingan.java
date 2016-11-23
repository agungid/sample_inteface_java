/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perangkingan;

/**
 *
 * @author whoami
 */
public class Perangkingan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Facebook dani = new Facebook();
        Twitter andi = new Twitter();
        
        //dani
        dani.setNama("Dani");
        dani.setPost("Mari kita belajar menghargai orang lain");
        dani.setLike(30);
        
        //andi
        andi.setNama("Andi");
        andi.setPost("Sudah terlanjur mencintai :D");
        andi.setLike(25);
        
        //Rating
        Rating rate = new Rating(dani, andi);
        
        System.out.println(rate.getRangking());
        
    }
    
}

interface SosialMedia{
    //Contoh variable    
    //Contoh Method
    public void setPost(String post);
    public String getPost();
    public void setLike(int like);
    public int getLike();
    public String jenis();
    
}

class Facebook implements SosialMedia{
    private String status;
    private int like;
    private String nama;
    
    @Override
    public void setPost(String post) {
        this.status=post;
    }

    @Override
    public String getPost() {
        return this.status;
    }

    @Override
    public void setLike(int count) {
        this.like=count;
    }

    @Override
    public int getLike() {
        return this.like;
    }
    
    @Override
    public String jenis(){
        return "Facebook";
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getNama(){
        return this.nama;
    }
    
}

class Twitter implements SosialMedia{
    
    private String twet;
    private int retwit;
    private String nama;
    
    @Override
    public void setPost(String post) {
        this.twet = post;
    }

    @Override
    public String getPost() {
        return this.twet;
    }

    @Override
    public void setLike(int like) {
        this.retwit = like;
    }

    @Override
    public int getLike() {
        return this.retwit;
    }
    
    @Override
    public String jenis(){
        return "Twitter";
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getNama(){
        return this.nama;
    }
    
}

//Depedensi Injection
class Rating{
    private Facebook facebook;
    private Twitter twitter;
    
    public Rating(Facebook facebook, Twitter twitter){
        this.facebook = facebook;
        this.twitter = twitter;
    }
    
    public String getRangking(){
        
        int fb = this.facebook.getLike();
        int tw = this.twitter.getLike();
        
        if(fb>tw){
            return this.facebook.jenis()+" "+this.facebook.getNama()+" lebih populer dari "+this.twitter.jenis()+" "+this.twitter.getNama();
        }else if(tw>fb){
            return this.twitter.jenis()+" "+this.twitter.getNama()+" lebih populer dari "+this.facebook.jenis()+" "+this.facebook.getNama();
        }else{
            return this.facebook.jenis()+" "+this.facebook.getNama()+" dan "+this.twitter.jenis()+" "+this.twitter.getNama()+" sama-sama populer ";
        }
    }
    
}
