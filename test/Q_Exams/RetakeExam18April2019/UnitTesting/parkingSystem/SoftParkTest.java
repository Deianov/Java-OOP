package Q_Exams.RetakeExam18April2019.UnitTesting.parkingSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SoftParkTest {
    private final String[] PARK_SPOTS = {"A1", "B2", "C3", "A2", "B3", "C4", "A3", "B4", "A4", "C1", "B1", "C2"};
    private final String NOT_EXIST_PARK_SPOT = "AAA";
    private final String PARKED_CAR_MASSAGE = "Car:%s parked successfully!";
    private final String REMOVE_CAR_MASSAGE = "Remove car:%s successfully!";
    private SoftPark softPark;
    private Car car;

    @Before
    public void init(){
        this.softPark = new SoftPark();
        this.car = new Car("Golf", "C1234BB");
    }

    @Test
    public void getParkingReturnNotNullCollection(){
        Assert.assertNotNull(softPark.getParking());
    }

    @Test
    public void getParkingInitialReturnCorrectSpotsCount(){
        Assert.assertEquals(PARK_SPOTS.length, softPark.getParking().size());
    }

    @Test
    public void getParkingInitialReturnCorrectEmptySpots(){
        boolean areEmpty = true;
        for (Car isEmpty : softPark.getParking().values()) {
            if(isEmpty != null) areEmpty = false;
        }
        Assert.assertTrue(areEmpty);
    }

//    @Test
//    public void getParkingInitialReturnCorrectSpots(){
//        String[] partSpotsNumbers = softPark.getParking().keySet().toArray(String[]::new);
//        Assert.assertArrayEquals(PARK_SPOTS, partSpotsNumbers);
//    }

    @Test(expected = UnsupportedOperationException.class)
    public void getParkingReturnUnmodifiableCollection(){
        this.softPark.getParking().clear();
    }

    @Test(expected = IllegalArgumentException.class)
    public void parkCarWithNotExistSpotShouldThrowException(){
        softPark.parkCar(NOT_EXIST_PARK_SPOT, car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parkingSpotIsAlreadyTakenShouldThrowException(){
        softPark.parkCar(PARK_SPOTS[0], car);
        softPark.parkCar(PARK_SPOTS[0], new Car("Golf2","CCC"));
    }
    @Test(expected = IllegalStateException.class)
    public void parkingCarIsAlreadyParked(){
        softPark.parkCar(PARK_SPOTS[0], car);
        softPark.parkCar(PARK_SPOTS[1], car);
    }

    @Test
    public void ParkingCarSuccessfullyMassage(){
        String massage = softPark.parkCar(PARK_SPOTS[0], car);
        String expected = String.format(PARKED_CAR_MASSAGE, car.getRegistrationNumber());
        Assert.assertEquals(expected, massage);
    }

    @Test
    public void ParkingCarSuccessfully(){
        softPark.parkCar(PARK_SPOTS[0], car);
        Assert.assertEquals(car, softPark.getParking().get(PARK_SPOTS[0]));
    }

    @Test
    public void removeCarSuccessfully(){
        softPark.parkCar(PARK_SPOTS[0], car);
        softPark.removeCar(PARK_SPOTS[0], car);
        Assert.assertNull(softPark.getParking().get(PARK_SPOTS[0]));
    }

    @Test
    public void removeCarMassage(){
        softPark.parkCar(PARK_SPOTS[0], car);
        String massage = softPark.removeCar(PARK_SPOTS[0], car);
        String expected = String.format(REMOVE_CAR_MASSAGE, car.getRegistrationNumber());
        Assert.assertEquals(expected, massage);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeCarFromNotExistSpotShouldThrowException(){
        softPark.removeCar(NOT_EXIST_PARK_SPOT, car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeCarNotExistInParkShouldThrowException(){
        softPark.removeCar(PARK_SPOTS[0], car);
    }
}