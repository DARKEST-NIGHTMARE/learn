public record Move(String name,int power,PokemonType moveType) {
    @Override
    public String toString(){
        return String.format("%s(%s,Power:%d)",name,moveType,power);
    }
}
