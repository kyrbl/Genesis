public class Board {
    private String name;
    private String id;

    private String key = "6320cc36f75cb4a361b88d6bb89f0b52";
    private String token = "75067b74d9595f89bf64692de8ae4f9e681c317c6b8fcaa4a059f2bc950cca51";

    public String getKey(){
        return key;
    }

    public String getToken(){
        return token;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getId(){
        return id;
    }
}
