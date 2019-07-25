import { CategoryDTO } from './categorydto';
import { UserDTO } from './userdto';
import { NovelDTO } from './novelsdto';

export class StoryDTO {
    
    id: number;

    title: string;

    plot: string;

    published: boolean;

    category: CategoryDTO[];

    user: UserDTO;

    like: UserDTO[];

    bookmark: UserDTO[];

    novel: NovelDTO;
}
