package com.example.mtbs.mapper;

import com.example.mtbs.dto.TheatorResponse;
import com.example.mtbs.entity.Theater;
import org.springframework.stereotype.Component;

@Component
public class TheatorMapper
{

    public TheatorResponse theater(Theater theater1)
    {
            if(theater1==null)
            {
                return null;
            }
            return new TheatorResponse(
                    theater1.getTheaterId(),
                    theater1.getName(),
                    theater1.getLandmark(),
                    theater1.getAddress(),
                    theater1.getCity()
            );
    }

    public TheatorResponse theatorResponseMapper(Theater theater1)
    {
        if(theater1==null)
        {
            return null;
        }
        return new TheatorResponse(
                theater1.getTheaterId(),
                theater1.getName(),
                theater1.getCity(),
                theater1.getAddress(),
                theater1.getLandmark()
        );
    }

//    public TheatorResponse updateTheatorMapper(Theater theater)
//    {
//        if(theater == null)
//        {
//            return null;
//        }
//        return new TheatorResponse(
//                theater.getTheaterId(),
//                theater.getName(),
//                theater.getCity(),
//                theater.getAddress(),
//                theater.getLandmark()
//        );
//    }
}
