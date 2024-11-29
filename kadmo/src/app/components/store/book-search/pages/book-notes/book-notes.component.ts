import { Component } from '@angular/core';

@Component({
  selector: 'app-book-notes',
  templateUrl: './book-notes.component.html',
  styleUrl: './book-notes.component.css'
})
export class BookNotesComponent {
  notes:any = [
    {
      autor: 'Jorge Luis Borges',
      note: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolor repellendus sunt porro voluptas mollitia? Eius ad ea maiores ratione ducimus, fugiat, saepe quisquam similique magnam perspiciatis laudantium reprehenderit laboriosam recusandae! Tempora, adipisci? Asperiores tenetur dolorem, repudiandae laborum voluptates iure neque cupiditate, perferendis error mollitia ratione ab accusantium magni, excepturi quisquam dolor. Mollitia minus est neque tempore non velit numquam corporis!.',
      img: 'img/user.jpg',
      publishedAt: '2021-09-01'
    },
    {
      autor: 'Alisa Grill',
      note: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolor repellendus sunt porro voluptas mollitia? Eius ad ea maiores ratione ducimus, fugiat, saepe quisquam similique magnam perspiciatis laudantium reprehenderit laboriosam recusandae! Tempora, adipisci? Asperiores tenetur dolorem, repudiandae laborum voluptates iure neque cupiditate, perferendis error mollitia ratione ab accusantium magni, excepturi quisquam dolor. Mollitia minus est neque tempore non velit numquam corporis!.',
      img: 'img/user.jpg',
      publishedAt: '2021-09-01'
    },
    {
      autor: 'Jorge Luis Borges',
      note: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolor repellendus sunt porro voluptas mollitia? Eius ad ea maiores ratione ducimus, fugiat, saepe quisquam similique magnam perspiciatis laudantium reprehenderit laboriosam recusandae! Tempora, adipisci? Asperiores tenetur dolorem, repudiandae laborum voluptates iure neque cupiditate, perferendis error mollitia ratione ab accusantium magni, excepturi quisquam dolor. Mollitia minus est neque tempore non velit numquam corporis!.',
      img: 'img/user.jpg',
      publishedAt: '2021-09-01'
    },
    {
      autor: 'Emma Gonzalez',
      note: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolor repellendus sunt porro voluptas mollitia? Eius ad ea maiores ratione ducimus, fugiat, saepe quisquam similique magnam perspiciatis laudantium reprehenderit laboriosam recusandae! Tempora, adipisci? Asperiores tenetur dolorem, repudiandae laborum voluptates iure neque cupiditate, perferendis error mollitia ratione ab accusantium magni, excepturi quisquam dolor. Mollitia minus est neque tempore non velit numquam corporis!.',
      img: 'img/user.jpg',
      publishedAt: '2021-09-01'
    }


  ]
}
