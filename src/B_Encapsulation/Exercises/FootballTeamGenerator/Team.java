package B_Encapsulation.Exercises.FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

class Team {
    private String name;
    private List<Player> players;

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    void addPlayer(Player player) {
        if (player != null) {
            this.players.add(player);
        }
    }

    void removePlayer(String name) {
        Player player = this.players
                .stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
        if (player == null) {
            throw new IllegalArgumentException("Player " + name + " is not in " + this.name + " team. ");
        }
        this.players.remove(player);
    }

    double getRating() {
        return Math.round(this.players
                .stream()
                .mapToDouble(Player::overallSkillLevel)
                .average()
                .orElse(0)
        );
    }

    @Override
    public String toString() {
        return String.format("%s - %.0f", this.name, this.getRating());
    }
}
