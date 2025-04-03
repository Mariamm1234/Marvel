import com.example.marvel.Data.local.entities.charactersEntity
import com.example.marvel.Data.remote.Dto.MarvelCharacter

//
//import com.example.marvel.Data.local.DTO.characters
//import com.example.marvel.Data.local.DTO.charactersDto
//import com.example.marvel.Data.local.DTO.comicsDto
//import com.example.marvel.Data.local.DTO.eventsDto
//import com.example.marvel.Data.local.DTO.seriesDto
//import com.example.marvel.Data.remote.Dto.Comics
//import com.example.marvel.Data.remote.Dto.Stories
//import com.example.marvel.Data.remote.Dto.MarvelCharacter
//import com.example.marvel.Data.remote.Dto.Series
//import com.example.marvel.Data.remote.Dto.Events
//import com.example.marvel.Data.remote.Dto.storiesDto
//
//
//fun Comics.toComicsDto():comicsDto{
//    return comicsDto(
//        id=id,
//        name=name,
//        modified = modified,
//        digitalId = digitalId
//    )
//}
//
//fun Stories.toStoriesDto():storiesDto{
//    return storiesDto(
//        id=id,
//        name=name,
//        modified = modified
//    )
//}
//
//fun Series.toSeriesDto():seriesDto{
//    return seriesDto(
//        id=id,
//        name=name,
//        startDate = startDate
//    )
//}
//
//fun Events.toEventsDto():eventsDto{
//    return eventsDto(
//        id=id,
//        name=name,
//        startDate = startDate
//    )
//}
fun MarvelCharacter.toCharactersEntity(): charactersEntity{
    return charactersEntity(
        id=id,
        name = name,
        description = description,
        modified=modified,
        image = ""

    )
}