import { CategoryDTO } from './categorydto';
import { UserDTO } from './userdto';
import { NovelDTO } from './novelsdto';

export class StoryDTO {
    
    id: number;

    title: string = '';

    plot: string = '';

    published: boolean = false;

    category: CategoryDTO = null;

    user: UserDTO = null;

    like: UserDTO[] = null;

    bookmark: UserDTO[] = null;

    novel: NovelDTO = null;
}
