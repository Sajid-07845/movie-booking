package com.example.mtbs.mapper;

import com.example.mtbs.dto.ScreenResponse;
import com.example.mtbs.entity.Screen;
import org.springframework.stereotype.Component;

@Component
public class ScreenMapper
{

    public ScreenResponse toResponseScreen(Screen screen)
    {
        if(screen == null)
        {
            return null;
        }
     return new ScreenResponse(
                screen.getScreeId(),
                screen.getScreenType(),
                screen.getCapacity(),
                screen.getNoOfRows()
        );
    }
}
