import java.util.*;
public class Album extends Song   {
    private String artist;
    private String name;
    List<Song> songs;

    public Album() {
    }

    public Album(String artist, String name) {
        this.artist = artist;
        this.name = name;
        this.songs=new ArrayList<>();
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public boolean findSong(String name){
        for(Song song:songs){
            if(song.getTitle().equals(name)){
                return true;
            }
        }
        return false;
    }

    public String addSong(String title,double duration){
        if(findSong(title)==false){
            Song song=new Song(title,duration);
            songs.add(song);
            return "Song added successfully";
        }
        return "Song already exist";
    }
public String addToPlaylistFromAlbums(String title, LinkedList<Song> playList){
        for(Song song:this.songs){
            if(song.getTitle().equals(title)){
                playList.add(song);
                return "Song has been added to your playlist successfully";
            }

        }
    return "Song doesn't exist in album";
}

public String addToPlaylistFromAlbums(int songNo, LinkedList<Song> playlist){
        int index=songNo-1;
        if(index>=0 && index<songs.size()){
            playlist.add(songs.get(index));
            return "Song has been added successfully";
        }
        return "incorrect song number";
}

}
