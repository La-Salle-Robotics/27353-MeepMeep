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
                .setConstraints(25, 50, Math.PI, Math.PI, 16.5)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(-36, -61.5, Math.toRadians(90)))
                .waitSeconds(3)
                .lineToY(38)
                .waitSeconds(1)
                .strafeTo(new Vector2d(38, 38))
                        .waitSeconds(1)
                        .lineToY(-50)
                        .waitSeconds(1)
                        .strafeTo(new Vector2d(-36, -60))
                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}