import { StoryDTO } from './storydto';
import { CategoryDTO } from './categorydto';
import { UserDTO } from './userdto';

export class NovelDTO {

    id: number;

    title: string;

    plot: string;

    category: CategoryDTO;

    // like: UserDTO[];

    // bookmark: UserDTO[];

    // madeBy: StoryDTO[];

}