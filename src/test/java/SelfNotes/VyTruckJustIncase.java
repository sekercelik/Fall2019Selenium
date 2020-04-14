package SelfNotes;

public class VyTruckJustIncase {

    //vy truck icinde calismazsa kullnabilir miyim diye bakilacak seyler..
/* @Test(description = "US3-AC1")
    public void driverSeeVehicleOdometerInfo(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("driver2");
        VehiclesTruckDriverPage truckDriver= new VehiclesTruckDriverPage();
        truckDriver.navigateTo("Fleet","Vehicle Odometer");
        VehicleOdometerTruckDriverPage info= new VehicleOdometerTruckDriverPage();
       // info.getAllHeaderInfo().getText();
//        System.out.println(info.getAllHeaderInfo().getText());
//        String expected ="ODOMETER VALUE\n" +
//                "DATE\n" + "DRIVER\n" + "UNIT\n" + "MODEL";
        Assert.assertTrue(info.getAllHeaderInfo().isDisplayed());
        System.out.println(info.getAllHeaderInfo().getText());
*/

//////////////////////////////////////////////////////////////////////////////////
//  calismayan seyleri vy truck projesinde incelemen lazim
    // page icindeki metotlara wait ekle dene hepsini
    /*  //US2-AC3: Verify that Store manager or sales manager should be able to add Vehicle Module and Vehicle Make

    @Test(description = "US2-AC3")
    public void addVehicleModuleAndVehicleMake() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("storemanager1");
        VehiclesStoreSalesManagerPage vehiclesInfo = new VehiclesStoreSalesManagerPage();
        vehiclesInfo.navigateTo("Fleet", "Vehicles");

        vehiclesInfo.clickFilterSymbol();
        vehiclesInfo.getManageFiltersButton().click();
        BrowserUtils.wait(4);

        vehiclesInfo.clickCheckboxLicencePlateOption();
        BrowserUtils.wait(4);

        vehiclesInfo.clickOpenedLicencePlate();
        BrowserUtils.wait(2);

        vehiclesInfo.getInputBoxForPlate().sendKeys("MyTestCar1");
        BrowserUtils.wait(4);

        vehiclesInfo.getUpdateButton().click();
        BrowserUtils.wait(4);

        vehiclesInfo.clickFirstCheckboxForCreatedCar();
        BrowserUtils.wait(3);

        vehiclesInfo.clickEditButtonAfterEnteringCreatedCar();
        BrowserUtils.wait(3);

 //not finished yet..

        vehiclesInfo.clickAddButtonForVehicleModel();
        BrowserUtils.wait(3);

        vehiclesInfo.clickChooseFirstModelName();
        BrowserUtils.wait(3);

        vehiclesInfo.select();
        BrowserUtils.wait(5);

        vehiclesInfo.clickAddButtonForVehicleMake();
        BrowserUtils.wait(3);

        vehiclesInfo.clickChooseAllMake();//ok
        BrowserUtils.wait(3);
//
//        vehiclesInfo.getInputBoxToCheckForMakes().sendKeys("Honda");//ok
//        BrowserUtils.wait(1);
//        vehiclesInfo.getUpdateButton().click();//ok
//        BrowserUtils.wait(3);
//
//        vehiclesInfo.clickChooseFirstMakeName();
//        BrowserUtils.wait(3);
//
//        vehiclesInfo.select();
//        BrowserUtils.wait(3);
//
//        vehiclesInfo.clickSaveAndCloseButton();
//
//        String expectedMessage ="Entity saved";
//        String actualMessage=vehiclesInfo.getEntitySavedMessage();
//        Assert.assertEquals(actualMessage,expectedMessage);
//
*/









}
