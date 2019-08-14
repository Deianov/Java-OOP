package Q_Exams.Exam11August2019.viceCity.models.neighbourhood;

import Q_Exams.Exam11August2019.viceCity.models.guns.Gun;
import Q_Exams.Exam11August2019.viceCity.models.players.Player;

import java.util.Collection;
import java.util.Iterator;

public class GangNeighbourhood implements Neighbourhood {
    private Player currentCivilPlayer = null;
    private Iterator<Player> playerIterator;

    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {

        Iterator<Gun>  gunIterator = mainPlayer.getGunRepository().getModels().iterator();
        playerIterator = civilPlayers.iterator();

        while (gunIterator.hasNext()) {

            Gun gun = gunIterator.next();

            while (gun.canFire()) {
                this.setCurrentCivilPlayer();

                if (this.currentCivilPlayer != null){
                    this.currentCivilPlayer.takeLifePoints(gun.fire());
                } else {
                    break;
                }
            }

            if (this.currentCivilPlayer == null) {
                break;
            }
        }

        for (Player civilPlayer : civilPlayers) {

            if (civilPlayer.isAlive()) {

                for (Gun gun : civilPlayer.getGunRepository().getModels()) {

                    while (gun.canFire() && mainPlayer.isAlive()) {
                        mainPlayer.takeLifePoints(gun.fire());
                    }
                    if (!mainPlayer.isAlive()) {
                        break;
                    }
                }
            }

            if (!mainPlayer.isAlive()) {
                break;
            }
        }
    }

    private void setCurrentCivilPlayer() {
        if (currentCivilPlayer == null || !currentCivilPlayer.isAlive()) {
            if (playerIterator.hasNext()) {
                currentCivilPlayer = playerIterator.next();
            } else {
                this.currentCivilPlayer = null;
            }
        }
    }
}
