package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(50, 50, Math.PI, Math.PI, 16.5)
                .setDimensions(17.785,17.323)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(23.5, -61.5, Math.toRadians(-90)))
                .waitSeconds(1)
                .strafeTo(new Vector2d(0, -34)) // score preload
                .strafeTo(new Vector2d(38,-34)) // go to push
                .strafeTo(new Vector2d(38,-10))
                .strafeToLinearHeading(new Vector2d(47,-10),Math.toRadians(0))

                .strafeTo(new Vector2d(47,-52))
                .strafeTo(new Vector2d(47,-10)) // second sample
                .strafeTo(new Vector2d(56,-10))
                .strafeTo(new Vector2d(56,-52))
                .strafeToLinearHeading(new Vector2d(38,-58), Math.toRadians(90)) // grab first specimen
                .strafeToLinearHeading(new Vector2d(0,-34), Math.toRadians(-90)) // score first specimen
                .strafeToLinearHeading(new Vector2d(38,-58), Math.toRadians(90)) // grab second specimen
                .strafeToLinearHeading(new Vector2d(0,-34), Math.toRadians(-90)) // score second specimen
                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}