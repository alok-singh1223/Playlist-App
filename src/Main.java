import java.util.LinkedList;
import java.util.ListIterator;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Album arjitAlbum=new Album("Arijit Singh","Arijit's albums");
        Album alanAlbum=new Album("Alan Walker","Waker's Album");

    arjitAlbum.addSong("Kesaria",3.5);
    arjitAlbum.addSong("Tum Kya Mile",4.2);
    arjitAlbum.addSong("Lal Ishq",5.1);

    alanAlbum.addSong("Faded",3.5);
    alanAlbum.addSong("Alone",4.1);
    alanAlbum.addSong("Dark Side",2.5);

    LinkedList<Song> myPlaylist=new LinkedList<>();

        System.out.println( arjitAlbum.addToPlaylistFromAlbums("Kesaria",myPlaylist));
        System.out.println(arjitAlbum.addToPlaylistFromAlbums(2,myPlaylist));
        System.out.println(arjitAlbum.addToPlaylistFromAlbums(5,myPlaylist));

        System.out.println(alanAlbum.addToPlaylistFromAlbums("Alone",myPlaylist));
        System.out.println(alanAlbum.addToPlaylistFromAlbums(3,myPlaylist));

        play(myPlaylist);

    }
    private static void play(LinkedList<Song> myPlaylist){
        if(myPlaylist.size()==0){
            System.out.println("Your playlist is empty");
            return;
        }

        ListIterator<Song> itr= myPlaylist.listIterator();
        System.out.println("Now playing:"+itr.next());

        Scanner sc=new Scanner(System.in);
        printMenu();

        boolean quit=false;
        while(!quit){
            System.out.println("Enter your choice");
            int choice=sc.nextInt();

            switch(choice){
                case 1:
                    printMenu();
                    break;
                case 2:
                   if(!itr.hasNext()){
                       System.out.println("You have reached the end of the playlist");
                   }
                   else{
                       System.out.println("Currently playing: "+itr.next());
                   }
                   break;
                case 3:
                    if(!itr.hasPrevious()){
                        System.out.println("You are the start of the playlist"+itr.previous());
                    }
                    else{
                        System.out.println("Currently playing: "+itr.previous());
                    }
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    printSongs(myPlaylist);
                    break;
                case 7:
                    quit=true;
                    break;
                default:
                    System.out.println("you Entered wrong choice.Please re-enter your choice!!");

            }

        }
    }

    private static void printSongs(LinkedList<Song> myPlaylist) {
     for(Song song:myPlaylist){
         System.out.println(song);
     }
     return;
    }

    private static void printMenu(){
        System.out.println();
        System.out.println("1. Show the menu again");
        System.out.println("2. Play next song");
        System.out.println("3. Previous song");
        System.out.println("4. Play current song again");
        System.out.println("5. Delete current song from playlist");
        System.out.println("6. Print all the song in playlist");
        System.out.println("7. Quit Application ");
    }

}
