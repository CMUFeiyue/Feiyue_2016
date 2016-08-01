package org.usfirst.frc.team9999.robot;
    
    import edu.wpi.first.wpilibj.IterativeRobot;
    import edu.wpi.first.wpilibj.command.Command;
    import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
    import org.usfirst.frc.team9999.robot.commands.DriveForward;
    import org.usfirst.frc.team9999.robot.subsystems.DriveMotor;
   import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
   import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
   import org.usfirst.frc.team9999.robot.Robot;
   
   public class Robot extends IterativeRobot {
	   public static final DriveMotor DRIVEMOTOR = new DriveMotor();

	public static final Subsystem DriveMotor = null;

	public static final String DRIVEMOTOR2 = null;
     public static OI oi;
   
     Command autonomousCommand;
     SendableChooser chooser;
   
     public void robotInit() {
          oi = new OI();
         chooser = new SendableChooser();
         chooser.addDefault("Default Auto", new DriveForward());
     //  chooser.addObject("My Auto", new MyAutoCommand());
         SmartDashboard.putData("Auto mode", chooser);
     }
      
     public void disabledInit(){
   
     }
      
      public void disabledPeriodic() {
          Scheduler.getInstance().run();
      }
   
     public void autonomousInit() {
         autonomousCommand = (Command) chooser.getSelected();           
         if (autonomousCommand != null) autonomousCommand.start();
     }
   
     public void autonomousPeriodic() {
         Scheduler.getInstance().run();
     }
   
     public void teleopInit() {
         if (autonomousCommand != null) autonomousCommand.cancel();
     }
   
     public void teleopPeriodic() {
         Scheduler.getInstance().run();
     }
       
     public void testPeriodic() {
         LiveWindow.run();
     }
     
   }
