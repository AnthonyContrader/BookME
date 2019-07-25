import {Usertype} from './usertype';
import { StoryDTO } from './storydto';
import { NovelDTO } from './novelsdto';

/**
 * Classe DTO di User. DEVE essere uguale (stesso nome classe, stessi attributi e stessi nomi) a
 * quello nel backend. 
 * 
 * @see Usertype
 * 
 * @author Vittorio Valent
 */
export class UserDTO {

   id: number;

   username: string;

   password: string;

   usertype: Usertype;

   stories: StoryDTO[];

   likedStories: StoryDTO[];

   bookmarkedStories: StoryDTO[];

   likedNovels: NovelDTO[];

   bookmarkedNovels: NovelDTO[];
}

